import os
import subprocess

from pathlib import Path

# Define paths
script_dir = Path(__file__).parent
image_dir = script_dir / 'sample-images'
base_output_dir = script_dir / 'outputs'

def run_llava_ocr(image_path):
    """Runs LLAVA OCR on the given image and returns the output."""
    try:
        result = subprocess.run(
            ["llava", "ocr", image_path], capture_output=True, text=True
        )
        return result.stdout.strip()
    except Exception as e:
        return f"Error processing {image_path}: {str(e)}"

def process_outputs_folder():
    """Iterates over the 'outputs' folder and processes images inside corresponding '_crops' subfolders."""
    base_dir = base_output_dir

    if not os.path.exists(base_dir):
        print("The 'outputs' folder does not exist.")
        return
    
    for folder in os.listdir(base_dir):
        folder_path = os.path.join(base_dir, folder)
        if not os.path.isdir(folder_path):
            continue
        
        crops_folder = os.path.join(folder_path, f"{folder}_crops")
        if not os.path.exists(crops_folder) or not os.path.isdir(crops_folder):
            print(f"Crops folder not found: {crops_folder}")
            continue
        
        for image in os.listdir(crops_folder):
            image_path = os.path.join(crops_folder, image)
            if os.path.isfile(image_path) and image.lower().endswith((".png", ".jpg", ".jpeg")):
                print(f"Processing {image_path}...")
                ocr_result = run_llava_ocr(image_path)
                print(f"OCR Result for {image}:")
                print(ocr_result)
                print("-" * 50)

process_outputs_folder()
