# Make sure to run this script from it's directory due to the relative path

import warnings
import numpy as np
import os
import cv2
from craft_text_detector import Craft

warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning)

image_dir = '../sample-images/'
output_dir = 'outputs/'

craft = Craft(output_dir=output_dir, crop_type="poly", cuda=False)

for filename in os.listdir(image_dir):
    if filename.lower().endswith(('.png', '.jpg', '.jpeg')):  
        image_path = os.path.join(image_dir, filename)
        print(f"Processing: {image_path}")

        prediction_result = craft.detect_text(image_path)
        segmented_output_dir = os.path.join(output_dir, filename.split('.')[0])
        os.makedirs(segmented_output_dir, exist_ok=True)


        segmented_images = prediction_result.get("text_crop_images", [])
        
        for idx, cropped_img in enumerate(segmented_images):
            cropped_img_path = os.path.join(segmented_output_dir, f"segment_{idx+1}.jpg")
            cv2.imwrite(cropped_img_path, cropped_img)
            print(f"Saved: {cropped_img_path}")

craft.unload_craftnet_model()
craft.unload_refinenet_model()