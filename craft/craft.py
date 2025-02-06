import warnings
import numpy as np

from craft_text_detector import Craft
warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning) 


image = '../sample-images/1.jpg'
output_dir = 'outputs/'
craft = Craft(output_dir=output_dir, crop_type="poly", cuda=False)
prediction_result = craft.detect_text(image)

craft.unload_craftnet_model()
craft.unload_refinenet_model()