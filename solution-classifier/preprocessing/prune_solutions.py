import os
from preprocessing_constants import *

# Prunes (deletes) all solution folders that are empty
for category_path in os.listdir(SOLUTIONS_DIR):
    category_folder = os.path.join(SOLUTIONS_DIR, category_path)
    if os.path.isdir(category_folder):
        if not os.listdir(category_folder):
            os.rmdir(category_folder)
            print(f"Deleted {category_folder}")