import os
from preprocessing_constants import *

try:
    for category_path in os.listdir(SOLUTIONS_DIR):
        category_folder = os.path.join(SOLUTIONS_DIR, category_path)
        if os.path.isdir(category_folder):
            files = [f for f in os.listdir(category_folder) if os.path.isfile(os.path.join(category_folder, f))]

            # two passes to avoid overwriting files
            for i, file in enumerate(files, start=1):
                new_name = f"{category_path}-temp-{i}.txt"
                old_path = os.path.join(category_folder, file)
                new_path = os.path.join(category_folder, new_name)
        
                os.rename(old_path, new_path)
                print(f"Renamed: {file} -> {new_name}")

            files = [f for f in os.listdir(category_folder) if os.path.isfile(os.path.join(category_folder, f))]
            for i, file in enumerate(files, start=1):
                new_name = f"{category_path}-{i}.txt"
                old_path = os.path.join(category_folder, file)
                new_path = os.path.join(category_folder, new_name)
        
                os.rename(old_path, new_path)
                print(f"Renamed: {file} -> {new_name}")
    
except Exception as e:
    print(f"An error occurred: {e}")
