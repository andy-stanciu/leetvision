import os
import random
import shutil
from pathlib import Path


def get_all_files(directory: str):
    file_list = []
    for root, _, files in os.walk(directory):
        for file in files:
            file_list.append(os.path.join(root, file))
    return file_list


def randomly_select_files(file_list: list, num_files: int):
    return random.sample(file_list, min(num_files, len(file_list)))


def copy_and_rename_files(file_list: list, destination: str):
    for file_path in file_list:
        try:
            file_name = os.path.basename(file_path)
            new_file_name = "FG-" + file_name
            destination_path = os.path.join(destination, new_file_name)
            shutil.copy(file_path, destination_path)
            print(f"Copied and renamed: {file_path} to {destination_path}")
        except Exception as e:
            print(f"Failed to copy and rename {file_path}: {e}")


def main():
    current_dir = Path(__file__).parent / "test_text"
    current_dir.mkdir(parents=True, exist_ok=True) #create directory if it doesn't exist
    
    target_directory = input("Enter the directory to search in: ")

    all_files = get_all_files(target_directory)

    if not all_files:
        print("No files found in the specified directory.")
        return

    selected_files = randomly_select_files(all_files, 100)

    copy_and_rename_files(selected_files, current_dir)


if __name__ == "__main__":
    main()