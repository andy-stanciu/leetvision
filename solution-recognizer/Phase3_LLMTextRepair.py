import google.generativeai as genai
import os

def fix_code(code, api_key):
    genai.configure(api_key=api_key)
    model = genai.GenerativeModel("gemini-pro")
    prompt = "The following code may contain typos and other artifacts, please correct it.\n\n" + code
    response = model.generate_content(prompt)
    return response.text if response else "No response received."


def phase3(code):    
    """
    Fetches the API key from the environment variables and corrects the provided code.
    
    Parameters:
        code (str): The input source code that may contain typos or errors.
    
    Returns:
        None: Prints the corrected code or exits with an error if the API key is not set.
    """
    print(f"Starting code correction process")
    API_KEY = os.getenv("GEMINI_KEY")  # Retrieve API key from environment variables
    
    if not API_KEY:
        print("Error: GEMINI_KEY environment variable not set.")
        exit(1)
    
    corrected_code = fix_code(code, API_KEY)
    return corrected_code
