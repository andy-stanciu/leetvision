import warnings
import numpy as np
import os
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

craft.unload_craftnet_model()
craft.unload_refinenet_model()