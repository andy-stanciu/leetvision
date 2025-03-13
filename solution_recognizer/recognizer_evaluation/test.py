import google.generativeai as genai
import argparse
from PIL import Image
import re
import os
import json
import cv2
from typing import List
from difflib import SequenceMatcher
import warnings
import matplotlib.pyplot as plt
from tqdm import tqdm
import time
import seaborn as sns


OCR_PROMPT = "Extract the text as code from this image, preserving the indentation. " \
                "Ensure that the code parses. " \
                "Output only the code block and nothing else. "

EXPERIMENT_DIR = "experiment_data"

def main():
    parser = argparse.ArgumentParser(description="Run or load OCR experiments.")
    parser.add_argument("-r", "--run", action="store_true", help="Run new experiments instead of loading existing data.")
    args = parser.parse_args()

    if args.run:
        print("Running experiments...")
        os.makedirs(EXPERIMENT_DIR, exist_ok=True)
        experiment_results = process_directories(os.getcwd())
        save_results(experiment_results)
    else:
        print("Loading previous experiment results...")
        experiment_results = load_results()

    plot_box(experiment_results)
    plot_violin(experiment_results)


def process_directories(base_dir):
    experiment_results = {}
    
    directories = [root for root, _, _ in os.walk(base_dir) if 'data' in os.path.basename(root)]
    
    for root in directories:
        print(f"Starting experiments for {str(root)}")
        dataset_name = os.path.basename(root)

        test_images_dir = os.path.join(root, 'test_images')
        test_text_dir = os.path.join(root, 'test_text')

        if os.path.isdir(test_images_dir) and os.path.isdir(test_text_dir):
            char_accs, word_accs, line_accs = [], [], []

            run_experiments(test_images_dir, test_text_dir, char_accs, word_accs, line_accs)

            experiment_results[dataset_name] = {
                "char_accs": char_accs,
                "word_accs": word_accs,
                "line_accs": line_accs
            }

    return experiment_results


def run_experiments(images_dir, text_dir, char_accs, word_accs, line_accs):
    image_files = [f for f in os.listdir(images_dir) if f.endswith(('.png', '.jpg', '.jpeg', '.bmp'))]

    for filename in tqdm(image_files, desc="Processing images", unit="image"):
        image_path = os.path.join(images_dir, filename)
        text_path = os.path.join(text_dir, f'{os.path.splitext(filename)[0]}.txt')

        if os.path.exists(text_path):
            with open(text_path, 'r', encoding='utf-8') as f:
                ground_truth = f.read()

            try:
                image = Image.open(image_path)
                ocr_result = extract_code_block(ocr_to_test(image, OCR_PROMPT))

                if ocr_result:
                    char_accs.append(character_level_accuracy(ocr_result, ground_truth))
                    word_accs.append(word_level_accuracy(ocr_result, ground_truth))
                    line_accs.append(line_level_accuracy(ocr_result, ground_truth))

            except Exception as e:
                print(f"Error processing {image_path}: {e}")



def plot_box(experiment_results):
    dataset_names = sorted(list(experiment_results.keys()))

    # Convert accuracies to percentage scale (0 to 100)
    char_accuracies = [[x * 100 for x in data['char_accs']] for data in experiment_results.values()]
    word_accuracies = [[x * 100 for x in data['word_accs']] for data in experiment_results.values()]
    line_accuracies = [[x * 100 for x in data['line_accs']] for data in experiment_results.values()]

    plt.figure(figsize=(15, 6))

    # Character Accuracy
    plt.subplot(1, 3, 1)
    plt.boxplot(char_accuracies, labels=dataset_names)
    plt.title('Character Accuracy')
    plt.xlabel('Datasets')
    plt.ylabel('Accuracy (%)')
    plt.ylim(-0.5, 100.5)
    plt.xticks(rotation=45)

    # Word Accuracy
    plt.subplot(1, 3, 2)
    plt.boxplot(word_accuracies, labels=dataset_names)
    plt.title('Word Accuracy')
    plt.xlabel('Datasets')
    plt.ylabel('Accuracy (%)')
    plt.ylim(-0.5, 100.5)
    plt.xticks(rotation=45)

    # Line Accuracy
    plt.subplot(1, 3, 3)
    plt.boxplot(line_accuracies, labels=dataset_names)
    plt.title('Line Accuracy')
    plt.xlabel('Datasets')
    plt.ylabel('Accuracy (%)')
    plt.ylim(-0.5, 100.5) 
    plt.xticks(rotation=45)

    plt.tight_layout()
    plt.show()


def plot_violin(experiment_results):
    dataset_names = sorted(list(experiment_results.keys()))

    # Convert accuracies to percentage scale (0 to 100)
    char_accuracies = [[x * 100 for x in data['char_accs']] for data in experiment_results.values()]
    word_accuracies = [[x * 100 for x in data['word_accs']] for data in experiment_results.values()]
    line_accuracies = [[x * 100 for x in data['line_accs']] for data in experiment_results.values()]

    plt.figure(figsize=(15, 6))

    # Character Accuracy
    plt.subplot(1, 3, 1)
    sns.violinplot(data=char_accuracies)
    plt.title('Character Accuracy')
    plt.xlabel('Datasets')
    plt.ylabel('Accuracy (%)')
    plt.ylim(-0.5, 100.5)
    plt.xticks(ticks=range(len(dataset_names)), labels=dataset_names, rotation=45)

    # Word Accuracy
    plt.subplot(1, 3, 2)
    sns.violinplot(data=word_accuracies)
    plt.title('Word Accuracy')
    plt.xlabel('Datasets')
    plt.ylabel('Accuracy (%)')
    plt.ylim(-0.5, 100.5)
    plt.xticks(ticks=range(len(dataset_names)), labels=dataset_names, rotation=45)

    # Line Accuracy
    plt.subplot(1, 3, 3)
    sns.violinplot(data=line_accuracies)
    plt.title('Line Accuracy')
    plt.xlabel('Datasets')
    plt.ylabel('Accuracy (%)')
    plt.ylim(-0.5, 100.5) 
    plt.xticks(ticks=range(len(dataset_names)), labels=dataset_names, rotation=45)

    plt.tight_layout()
    plt.show()


def save_results(data):
    with open(os.path.join(EXPERIMENT_DIR, 'results.json'), 'w') as f:
        json.dump(data, f)


def load_results():
    try:
        with open(os.path.join(EXPERIMENT_DIR, 'results.json'), 'r') as f:
            return json.load(f)
    except FileNotFoundError:
        print("No previous results found.")
        return {}


def ocr_to_test(image, prompt, verbose=False):
    time.sleep(5) # delay to avoid quota limit

    key = os.getenv("GEMINI_KEY")
    if key is None:
        raise SystemError("Gemini API key not configured")
    
    genai.configure(api_key=key)

    model = genai.GenerativeModel("gemini-1.5-flash")
    response = model.generate_content([image, prompt])

    if verbose:
        print(f'Extracted text:\n\n{response.text}\n')
    return response.text


def extract_code_block(text):
    match = re.search(r"```(?:[a-zA-Z]+)?\n(.*?)\n```", text, re.DOTALL)
    if match:
        return match.group(1).strip()
    else:
        return None


def character_level_accuracy(generated_text: str, actual_text: str) -> float:
    """
    Calculate the character-level similarity between two texts.
    """
    matcher = SequenceMatcher(None, generated_text, actual_text)
    similarity = matcher.ratio()  # Ratio of matching characters
    return similarity


def word_level_accuracy(generated_text: str, actual_text: str) -> float:
    """
    Calculate the word-level similarity between two texts.
    """
    generated_words = generated_text.split()
    actual_words = actual_text.split()

    matcher = SequenceMatcher(None, generated_words, actual_words)
    similarity = matcher.ratio()  # Ratio of matching words
    return similarity


def line_level_accuracy(generated_text: str, actual_text: str) -> float:
    """
    Calculate the line-level accuracy between two texts.
    """
    generated_lines = [line.strip() for line in generated_text.splitlines()]
    actual_lines = [line.strip() for line in actual_text.splitlines()]

    min_lines = min(len(generated_lines), len(actual_lines))
    correct_lines = 0

    for i in range(min_lines):
        if generated_lines[i] == actual_lines[i]:
            correct_lines += 1

    if len(actual_lines) == 0:
        return 1.0 if len(generated_lines) == 0 else 0.0

    return correct_lines / len(actual_lines)


if __name__ == "__main__":
    main()