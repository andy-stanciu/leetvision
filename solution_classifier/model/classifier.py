import warnings

warnings.filterwarnings("ignore", message="An issue occurred while importing 'torch-scatter'")
warnings.filterwarnings("ignore", message="An issue occurred while importing 'torch-sparse'")

import torch
import subprocess
from .knn import *
from .graph_util import *
from torch_geometric.utils import from_networkx
from solution_classifier.model.model_constants import *

NODE_FEATURES = 194
DEVICE = "cpu"
COOCCURRENCES = "backend/cooccurrences.txt"

def parse_code_block(code_block):
    command = ["java", "-jar", "backend/leetvision-parser-1.0.jar", code_block]
    result = subprocess.run(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    
    if result.returncode != 0:
        return (False, result.stderr)
    else:
        return (True, result.stdout)
    
def vectorize_edges(edges, verbose=False):
    graph = read_nodes_from_string(edges, dims=NODE_FEATURES, path=COOCCURRENCES)
    cooccurrences = []
    for _, data_dict in graph.nodes(data=True):
        cooccurrences.append(data_dict['cooccurrences'])
        data_dict.pop('cooccurrences', None)
    
    data = from_networkx(graph)
    
    node_cooccurrences = np.array(cooccurrences)
    data.x = torch.from_numpy(node_cooccurrences).float()

    if verbose:
        print("Vectorized:\n")
        _print_stats(data)
        print()
        
    return data

def predict_question(solution_vec, verbose=False):
    knn = load_knn("backend/knn/knn_statpool_194d", 
                   embedding_method=_global_stats_pool, 
                   pca_dim=NODE_FEATURES, verbose=verbose)
    c, k = 5, 5

    knn.update_k(k)
    preds = knn.predict(solution_vec, metric="cosine", top_c=c).numpy().flatten()
    if verbose:
        print(f"\nTop {c} out of {k} nearest neighbors:")
        for pred in preds:
            print(f"{pred}: {QUESTIONS[pred]}")
        print()

    return [QUESTIONS[pred] for pred in preds]

def map_questions(questions):
    return [(question, QUESTION_IDS[question]) for question in questions]

def _print_stats(data):
    print(data)
    print('=============================================================')
    print(f'Number of nodes: {data.num_nodes}')
    print(f'Number of edges: {data.num_edges}')
    print(f'Average node degree: {data.num_edges / data.num_nodes:.2f}')
    print(f'Has isolated nodes: {data.has_isolated_nodes()}')
    print(f'Has self-loops: {data.has_self_loops()}')
    print(f'Is undirected: {data.is_undirected()}')
    print('=============================================================')
    print(f'Data.x: {data.x}')
    print(f'Data.y: {data.y}')

def _global_stats_pool(data):
    """
    Compute a richer graph-level embedding by concatenating:
      - The mean of node features,
      - The maximum of node features,
      - The standard deviation of node features.
    If the graph is empty, return a zero vector.
    """
    feature_dim = NODE_FEATURES  # Known number of features.
    if data is None or data.x.size(0) == 0:
        return torch.zeros(feature_dim * 3, device=DEVICE)
    mean = data.x.mean(dim=0)
    max_val = data.x.max(dim=0)[0]
    std = data.x.std(dim=0, unbiased=False)
    return torch.cat([mean, max_val, std], dim=0)