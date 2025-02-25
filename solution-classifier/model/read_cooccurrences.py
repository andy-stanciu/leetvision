import numpy as np
import matplotlib.pyplot as plt
from sklearn.decomposition import PCA

from constants import *

COOCCURRENCES = '../cooccurrences.txt'

def parse_cooccurrences(filename):
    cooccurrences = {}
    with open(filename, 'r') as file:
        for line in file:
            # Remove leading/trailing whitespace
            line = line.strip()
            if not line:
                continue  # Skip empty lines
            # Split the line at the colon
            if ':' not in line:
                print(f"Skipping invalid line (no colon found): {line}")
                continue
            key, values_str = line.split(':', 1)
            # Convert values to a list of integers
            try:
                values = [int(num) for num in values_str.strip().split()]
            except ValueError:
                print(f"Invalid numbers in line: {line}")
                continue
            # Convert list to NumPy array
            values_array = np.array(values)
            # Add to dictionary
            cooccurrences[key] = values_array
    return cooccurrences

def strip_empty_cooccurrences(cooccurrences):
    to_remove = []
    for k, v in cooccurrences.items():
        if np.all(v == 0):
            to_remove.append(k)
    
    for k in to_remove:
        del cooccurrences[k]

def normalize(arr):
    arr_mean = arr.mean()
    arr_std = arr.std()
    # Avoid division by zero
    if arr_std == 0:
        return np.zeros_like(arr, dtype=float)
    normalized = (arr - arr_mean) / arr_std
    return normalized

def read_cooccurrences(strip=False):
    cooccurrences = parse_cooccurrences(COOCCURRENCES)

    if strip:
        strip_empty_cooccurrences(cooccurrences)

    for k, v in cooccurrences.items():
        cooccurrences[k] = normalize(v)
    return cooccurrences

if __name__ == "__main__":
    cooccurrences = read_cooccurrences(strip=True)
    
    # Step 1: Extract k-dimensional vectors and their keys
    keys = list(cooccurrences.keys())
    vectors = np.array(list(cooccurrences.values()))

    # Step 2: Apply PCA to project into 2D space
    pca = PCA(n_components=2)
    reduced_vectors = pca.fit_transform(vectors)

    # Step 3: Plot the 2D points
    plt.figure(figsize=(16, 10))

    for i, key in enumerate(keys):
        plt.scatter(reduced_vectors[i, 0], reduced_vectors[i, 1], label=key)
        plt.text(reduced_vectors[i, 0] + 0.1, reduced_vectors[i, 1] + 0.1, key, fontsize=10)
   
    plt.title("Meta Language Co-occurrences")
    plt.xlabel("Principal Component 1")
    plt.ylabel("Principal Component 2")
    plt.axhline(0, color='gray', linewidth=0.5, linestyle='--')
    plt.axvline(0, color='gray', linewidth=0.5, linestyle='--')
    plt.grid()
    plt.show()