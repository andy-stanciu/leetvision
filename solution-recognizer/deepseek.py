import os
# Disable xformers memory-efficient attention via environment variable
os.environ["XFORMERS_DISABLE"] = "1"

import torch
import torch.nn.functional as F
from transformers import AutoModelForCausalLM, AutoProcessor
from deepseek_vl2.models import DeepseekVLV2Processor, DeepseekVLV2ForCausalLM
from deepseek_vl2.utils.io import load_pil_images

# --- Define a CPU-friendly fallback for memory-efficient attention ---
def fallback_memory_efficient_attention(query, key, value, attn_bias=None, p=0.0):
    # Use PyTorch's scaled dot-product attention as fallback.
    # This fallback assumes no attention bias and non-causal attention.
    return F.scaled_dot_product_attention(query, key, value,
                                            attn_mask=None,
                                            dropout_p=p,
                                            is_causal=False)

# --- Override xformers dispatch fallback ---
try:
    import xformers.ops.fmha.dispatch as fmha_dispatch

    def fallback_dispatch_fw(*args, **kwargs):
        # Expect the first argument (inp) to be a tuple/list with at least 5 elements.
        inp = args[0]
        if isinstance(inp, (tuple, list)) and len(inp) >= 5:
            query, key, value, attn_bias, p = inp[:5]
            return fallback_memory_efficient_attention(query, key, value, attn_bias, p)
        else:
            raise ValueError("Fallback dispatch expected tuple/list with at least 5 elements, got: " + str(inp))
    
    fmha_dispatch._dispatch_fw = fallback_dispatch_fw
    print("Monkey-patched xformers._dispatch_fw fallback.")
except ImportError:
    print("xformers dispatch not available for patching.")

# --- Also override the main memory-efficient attention function and _fMHA.apply ---
try:
    import xformers.ops.fmha.__init__ as fmha_ops

    fmha_ops.memory_efficient_attention = fallback_memory_efficient_attention
    # Override the _fMHA.apply method so that it uses our fallback.
    fmha_ops._fMHA.apply = lambda *args, **kwargs: fallback_memory_efficient_attention(*args[1:], **kwargs)
    print("Monkey-patched xformers.memory_efficient_attention and _fMHA.apply fallback.")
except ImportError:
    print("xformers not installed or could not be patched.")

def cast_floats_to_float32(obj):
    """Recursively convert any torch.Tensor in a structure to float32 if it is a floating type."""
    if isinstance(obj, torch.Tensor):
        if obj.dtype.is_floating_point:
            return obj.float()
        return obj
    elif isinstance(obj, dict):
        return {k: cast_floats_to_float32(v) for k, v in obj.items()}
    elif isinstance(obj, list):
        return [cast_floats_to_float32(v) for v in obj]
    else:
        return obj

# Set the default floating point type to float32 globally.
torch.set_default_dtype(torch.float32)

# Force device to CPU and dtype to float32.
device = torch.device("cpu")
dtype = torch.float32
print("Using device:", device)

# Specify the model path (using the tiny variant)
model_path = "deepseek-ai/deepseek-vl2-tiny"

# Load the processor and tokenizer.
vl_chat_processor = DeepseekVLV2Processor.from_pretrained(model_path)
tokenizer = vl_chat_processor.tokenizer

# Load the model with trust_remote_code enabled and force parameters to float32.
vl_gpt = AutoModelForCausalLM.from_pretrained(model_path, trust_remote_code=True)
vl_gpt = vl_gpt.to(device, dtype=dtype).float()
vl_gpt.eval()

# Disable xformers in the model's configuration if available.
if hasattr(vl_gpt.config, "use_xformers"):
    vl_gpt.config.use_xformers = False
    print("Disabled xformers (memory efficient attention) via config.")

# Monkey-patch the vision module to force its inputs to float32.
if hasattr(vl_gpt, "vision"):
    orig_vision_forward = vl_gpt.vision.forward
    def patched_vision_forward(x, *args, **kwargs):
        return orig_vision_forward(x.float(), *args, **kwargs)
    vl_gpt.vision.forward = patched_vision_forward
    print("Patched vision.forward to force float32.")

## Single image conversation example:
conversation = [
    {
        "role": "<|User|>",
        "content": "<image>\nExtract the code from the image as plain text.",
        "images": ["./sample-images/two-sum.jpg"],
    },
    {"role": "<|Assistant|>", "content": ""},
]

# Load images and prepare inputs (on CPU).
pil_images = load_pil_images(conversation)
prepare_inputs = vl_chat_processor(
    conversations=conversation,
    images=pil_images,
    force_batchify=True,
    system_prompt=""
).to(device)

# Recursively cast all tensors in prepare_inputs to float32.
prepare_inputs = cast_floats_to_float32(prepare_inputs)

# Prepare image embeddings and cast them explicitly to float32.
inputs_embeds = vl_gpt.prepare_inputs_embeds(**prepare_inputs)
inputs_embeds = inputs_embeds.float()
print("Inputs_embeds dtype:", inputs_embeds.dtype)

# Ensure the attention_mask is cast appropriately if present.
if "attention_mask" in prepare_inputs:
    prepare_inputs["attention_mask"] = cast_floats_to_float32(prepare_inputs["attention_mask"])

# Generate a response from the model (in no_grad mode).
with torch.no_grad():
    outputs = vl_gpt.language_model.generate(
        inputs_embeds=inputs_embeds,
        attention_mask=prepare_inputs.get("attention_mask", None),
        pad_token_id=tokenizer.eos_token_id,
        bos_token_id=tokenizer.bos_token_id,
        eos_token_id=tokenizer.eos_token_id,
        max_new_tokens=512,
        do_sample=False,
        use_cache=True
    )

answer = tokenizer.decode(outputs[0].cpu().tolist(), skip_special_tokens=True)
print(f"{prepare_inputs['sft_format'][0]}", answer)