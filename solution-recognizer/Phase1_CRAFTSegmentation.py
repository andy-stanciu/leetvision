import warnings
import numpy as np
import os
import cv2
from pathlib import Path
from craft_text_detector import Craft
import sys

def phase1(image_path_str):
    """
    Process the image for text detection using CRAFT, save cropped text images,
    and store them in an output folder.
    
    Args:
    - image_path_str: str, the full path of the image to process
    """
    warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning)
    warnings.filterwarnings('ignore', category=UserWarning)

    # Convert string path to Path object
    image_path = Path(image_path_str)

    if not image_path.exists():
        print(f"Error: The image {image_path} does not exist.")
        return

    print(f"Starting image segmentation for {image_path}")

    # Define output directory
    base_output_dir = image_path.parent / 'outputs'

    # Create a folder named after the image (without extension) inside 'outputs/'
    image_folder = base_output_dir / image_path.stem
    image_folder.mkdir(parents=True, exist_ok=True)

    # Initialize CRAFT with the image-specific output folder
    craft = Craft(output_dir=str(image_folder), crop_type="poly", cuda=False)

    # Detect text
    prediction_result = craft.detect_text(str(image_path))

    # Save cropped text images inside the image folder
    segmented_images = prediction_result.get("text_crop_images", [])

    for idx, cropped_img in enumerate(segmented_images):
        cropped_img_path = image_folder / f"segment_{idx+1}.jpg"
        cv2.imwrite(str(cropped_img_path), cropped_img)
        print(f"Saved: {cropped_img_path}")

    # Unload models to free memory
    craft.unload_craftnet_model()
    craft.unload_refinenet_model()
