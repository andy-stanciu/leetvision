import google.generativeai as genai
from PIL import Image
import re
import os
import json

def extract_text(image, prompt, verbose=False):
    key = os.getenv("GEMINI_KEY")
    if key is None:
        raise SystemError("Gemini API key not configured")
    
    genai.configure(api_key=key)

    model = genai.GenerativeModel("gemini-1.5-flash") # best vision model
    response = model.generate_content([image, prompt])

    if verbose:
        print(f'Extracted text:\n\n{response.text}\n')
    return response.text

def extract_code_block(text):
    """
    Extract code blocks from a given string.

    Each code block is expected to be in the format:
    ```[language]
    code...
    ```
    
    Returns a list of tuples containing the language (or an empty string if not provided)
    and the code itself.
    """
    # The regex pattern:
    # - ``` starts the code block
    # - (\w+)? optionally captures the language specifier (one or more word characters)
    # - \s* allows for any whitespace after the language specifier
    # - (.*?) lazily captures the code content until the next triple backticks
    # - ``` ends the code block
    pattern = r"```(\w+)?\s*(.*?)```"
    matches = re.findall(pattern, text, flags=re.DOTALL)
    # Each match is a tuple (language, code)
    return matches

def map_language(lang):
    lang = lang.lower()
    if lang == 'java':
        return 'java'
    elif lang == 'c++' or lang == 'cpp':
        return 'cpp'
    elif lang == 'python' or lang == 'python3':
        return 'python3'
    elif lang == 'c':
        return 'c'
    elif lang == 'c#' or lang == 'csharp':
        return 'csharp'
    elif lang == 'javascript' or lang == 'js':
        return 'javascript'
    elif lang == 'typescript' or lang == 'ts':
        return 'typescript'
    elif lang == 'go' or lang == 'golang':
        return 'golang'
    else:
        raise ValueError()

def unescape_code(s: str) -> str:
    return json.loads(s)

def escape_code(s: str) -> str:
    return json.dumps(s)
