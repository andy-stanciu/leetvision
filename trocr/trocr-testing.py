from transformers import TrOCRProcessor, VisionEncoderDecoderModel

import requests

from PIL import Image
import time

start_time = time.time()

processor = TrOCRProcessor.from_pretrained("microsoft/trocr-base-handwritten")

model = VisionEncoderDecoderModel.from_pretrained("microsoft/trocr-base-handwritten")

# load image from the IAM dataset

# url = "https://fki.tic.heia-fr.ch/static/img/a01-122-02.jpg"
# image = Image.open(requests.get(url, stream=True).raw).convert("RGB")
image_path = "/home/rich/Downloads/Image2.png"
image = Image.open(image_path).convert("RGB")

pixel_values = processor(image, return_tensors="pt").pixel_values

generated_ids = model.generate(pixel_values)

generated_text = processor.batch_decode(generated_ids, skip_special_tokens=True)[0]

print(generated_text)

end_time = time.time()
elapsed_time = end_time - start_time
print(f"Elapsed time: {elapsed_time:.4f} seconds")