import os
import subprocess
from pathlib import Path
import pytesseract
from PIL import Image
import sys

script_dir = Path(__file__).parent
base_output_dir = script_dir / 'outputs'

def run_ocr(image_path):
    try:
        image = Image.open(image_path)
        ocr_result = pytesseract.image_to_string(image)
        return ocr_result
    except Exception as e:
        print(f"Error during OCR processing for {image_path}: {e}")
        return ""


def process_output_folder(folder_name):
    folder_path = base_output_dir / folder_name
    
    if not folder_path.exists():
        return f"The folder '{folder_name}' does not exist in the 'outputs' directory.\n"
    
    crops_folder = folder_path / f"{folder_name}_crops"
    if not crops_folder.exists() or not crops_folder.is_dir():
        return f"Crops folder not found: {crops_folder}\n"
    
    ocr_results = []
    for image in sorted(os.listdir(crops_folder)):
        image_path = crops_folder / image
        if image_path.is_file() and image.lower().endswith((".png", ".jpg", ".jpeg")):
            ocr_results.append(run_ocr(image_path))
    
    return "\n".join(ocr_results)


def phase2(folder_name):
    """
    Run OCR on the cropped text images in the specified folder and return the results as a string.
    
    Args:
    - folder_name: str, the name of the folder to process within 'outputs'.
    
    Returns:
    - str: OCR output including new lines.
    """
    print(f"Starting OCR for {folder_name}")
    return process_output_folder(folder_name)