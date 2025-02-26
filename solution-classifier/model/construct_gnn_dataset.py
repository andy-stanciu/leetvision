import os
import torch
import numpy as np
import random
from torch_geometric.data import Dataset
from torch_geometric.utils import from_networkx
from graph_util import *
import networkx as nx
import matplotlib.pyplot as plt
import pickle

QUESTION_COUNT = len(QUESTIONS)

class SolutionDataset(Dataset):
    def __init__(self, root, transform=None, pre_transform=None):
        super(SolutionDataset, self).__init__()
        self.root = root
        self.transform = transform
        self.pre_transform = pre_transform
        
        self.selected_folders = QUESTIONS[:QUESTION_COUNT]
        
        self.solution_files = []
        for folder_idx, folder in enumerate(self.selected_folders):
            folder_path = os.path.join(root, folder)
            files = sorted(os.listdir(folder_path))
            self.solution_files.extend([(folder_idx, folder, os.path.join(folder_path, f)) for f in files])
    
    def len(self):
        return len(self.solution_files)

    def get(self, idx):
        folder_idx, _, path = self.solution_files[idx]
        graph = read_nodes(path)

        cooccurrences = []
        for _, data_dict in graph.nodes(data=True):
            cooccurrences.append(data_dict['cooccurrences'])
            data_dict.pop('cooccurrences', None)
        
        data = from_networkx(graph)
        
        node_cooccurrences = np.array(cooccurrences)
        data.x = torch.from_numpy(node_cooccurrences).float()

        # label = np.zeros(QUESTION_COUNT)
        # label[folder_idx] = 1
        # data.y = torch.tensor(label, dtype=torch.long)
        
        data.y = torch.tensor(folder_idx, dtype=torch.long)

        return data

    def visualize(self, idx):
        _, folder, path = self.solution_files[idx]
        graph = read_nodes(path)
        pos = hierarchy_pos(graph)
        fig = plt.figure(figsize=(10, 8))
        fig.canvas.manager.set_window_title(folder)
        nx.draw(
            graph,
            pos,
            with_labels=True,
            arrows=True,
            node_size=25,
            node_color="lightblue",
            font_size=8,
            font_color="black",
            edge_color="gray"
        )
        plt.title(folder)
        plt.show()
    
    def get_solution_path(self, idx):
        return self.solution_files[idx]
    

def main():
    solutions = SolutionDataset(root='../edges')
    print(f'total solution count: {len(solutions)}')

    with open('../edges.pkl', 'wb') as f:
        pickle.dump(solutions, f)

    print("Dataset serialized and saved to '../edges.pkl'")

    # sample 1 random solution
    solution_nums = random.sample(range(0, len(solutions)), k=1)
    for solution_num in solution_nums:
        solutions.visualize(solution_num)
        data = solutions.get(solution_num)
        _, solution, _ = solutions.get_solution_path(solution_num)
        print('==========================')
        print(f'Solution: {solution}')
        print(f'Solution index: {solution_num}')
        print(data)
        print(f'Number of nodes: {data.num_nodes}')
        print(f'Number of edges: {data.num_edges}')
        print(f'Average node degree: {data.num_edges / data.num_nodes:.2f}')
        print(f'Has isolated nodes: {data.has_isolated_nodes()}')
        print(f'Has self-loops: {data.has_self_loops()}')
        print(f'Is undirected: {data.is_undirected()}')
        print(f'x: {data.x}')
        print(f'y: {data.y}')
        print('==========================')

if __name__ == "__main__":
    main()