# When saving, store the complete Data objects
import torch
import os
from construct_dataset import SolutionDataset

dataset = SolutionDataset(root='../edges')

CHUNK_SIZE = 100000 # adjust based on available memory
train_data_list = []
test_data_list = []
num_items = len(dataset)

for i in range(num_items):
    data = dataset.get(i)  # each data is a full PyG Data object
    if (i + 1) % 10 == 0:
        test_data_list.append(data)
    else:
        train_data_list.append(data)
    
    # Save chunks when the chunk size is reached
    if (i + 1) % CHUNK_SIZE == 0:
        chunk_idx = (i + 1) // CHUNK_SIZE
        
        train_filename = f'train/10d/chunk_{chunk_idx}.pt'
        torch.save(train_data_list, train_filename)
        print(f'Saved {len(train_data_list)} training samples to {train_filename}')
        
        test_filename = f'test/10d/chunk_{chunk_idx}.pt'
        torch.save(test_data_list, test_filename)
        print(f'Saved {len(test_data_list)} test samples to {test_filename}')
        
        train_data_list, test_data_list = [], []

# Save any remaining samples
if train_data_list or test_data_list:
    chunk_idx = (num_items // CHUNK_SIZE) + 1
    train_filename = f'train/10d/chunk_{chunk_idx}.pt'
    torch.save(train_data_list, train_filename)
    print(f'Saved {len(train_data_list)} training samples to {train_filename}')
    
    test_filename = f'test/10d/chunk_{chunk_idx}.pt'
    torch.save(test_data_list, test_filename)
    print(f'Saved {len(test_data_list)} test samples to {test_filename}')