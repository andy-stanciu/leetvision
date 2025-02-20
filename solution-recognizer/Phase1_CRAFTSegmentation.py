import warnings
import numpy as np
import os
import cv2
from pathlib import Path
from craft_text_detector import Craft
import sys

def phase1(image_filename):
    """
    Process the image for text detection using CRAFT, save cropped text images,
    and store them in an output folder.
    
    Args:
    - image_filename: str, the name of the image to process (including extension)
    """
    warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning)
    warnings.filterwarnings('ignore', category=UserWarning)

    # Define paths
    script_dir = Path(__file__).parent
    image_dir = script_dir / 'sample-images'
    base_output_dir = script_dir / 'outputs'

    # Construct the full path for the specified image
    image_path = image_dir / image_filename

    if not image_path.exists():
        print(f"Error: The image {image_filename} does not exist in the {image_dir} folder.")
        return

    print(f"Starting image segmentation for {image_path}")

    # Create a folder named after the image (without extension) inside 'outputs/'
    image_folder = base_output_dir / Path(image_filename).stem
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
