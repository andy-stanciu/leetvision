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

    if not os.path.exists(folder_path):
        print(f"The folder '{folder_name}' does not exist in the 'outputs' directory.")
        return

    crops_folder = folder_path / f"{folder_name}_crops"
    if not os.path.exists(crops_folder) or not os.path.isdir(crops_folder):
        print(f"Crops folder not found: {crops_folder}")
        return
    
    for image in sorted(os.listdir(crops_folder)):
        image_path = crops_folder / image
        if os.path.isfile(image_path) and image.lower().endswith((".png", ".jpg", ".jpeg")):
            ocr_result = run_ocr(image_path)
            print(f"{ocr_result}")


def phase2(folder_name):
    """
    Run OCR on the cropped text images in the specified folder and print the results.
    
    Args:
    - folder_name: str, the name of the folder to process within 'outputs'.
    """
    print(f"Starting OCR processing for folder: {folder_name}")
    process_output_folder(folder_name)