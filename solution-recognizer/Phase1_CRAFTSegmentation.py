import warnings
import numpy as np
import os
import cv2
from pathlib import Path
from craft_text_detector import Craft

warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning)

# Define paths
script_dir = Path(__file__).parent
image_dir = script_dir / 'sample-images'
base_output_dir = script_dir / 'outputs'

# Process each image
for filename in os.listdir(image_dir):
    if filename.lower().endswith(('.png', '.jpg', '.jpeg')):  
        image_path = image_dir / filename
        print(f"Processing: {image_path}")

        # Create a folder named after the image (without extension) inside 'outputs/'
        image_folder = base_output_dir / Path(filename).stem
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
