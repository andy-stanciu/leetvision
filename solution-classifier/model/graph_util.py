import io
import networkx as nx
import matplotlib.pyplot as plt
from read_cooccurrences import *

def hierarchy_pos(G, root=None, width=10.0, vert_gap=0.2, vert_loc=0, xcenter=0.5):
    """
    Generate positions for a hierarchical tree layout.
    Parameters:
    - G: The graph (assumed to be a directed tree)
    - root: The root node of the tree
    - width: Width of the plot
    - vert_gap: Gap between levels of the hierarchy
    - vert_loc: Initial vertical location
    - xcenter: Center of the root node
    """
    if not nx.is_tree(G):
        raise TypeError("Input graph must be a tree.")

    if root is None:
        root = next(iter(nx.topological_sort(G)))  # Assume G is a directed tree.

    def _hierarchy_pos(G, node, left, right, vert_loc, pos, parent=None):
        pos[node] = ((left + right) / 2, vert_loc)
        children = list(G.neighbors(node))
        if not children:
            return pos
        width = (right - left) / len(children)
        for i, child in enumerate(children):
            pos = _hierarchy_pos(G, child, left + i * width, left + (i + 1) * width,
                                 vert_loc - vert_gap, pos, parent=node)
        return pos

    return _hierarchy_pos(G, root, 0, width, vert_loc, {})

def read_nodes(file):
    try:
        graph = nx.DiGraph()
        cooccurrences = read_cooccurrences()
        with open(file, 'r') as file:
            for line in file:
                line = line.strip()
                if not line or line.startswith('#'):
                    continue  # Skip empty lines and comments

                parts = line.split()
                if len(parts) != 4:
                    continue  # Skip lines that don't have exactly 4 elements

                node1_id, node1_name, node2_id, node2_name = parts
                
                if not graph.has_node(node1_id):
                    graph.add_node(node1_id, name=node1_name, cooccurrences=cooccurrences[node1_name])
                if not graph.has_node(node2_id):
                    graph.add_node(node2_id, name=node2_name, cooccurrences=cooccurrences[node2_name])

                graph.add_edge(node1_id, node2_id)
        
        return graph
    except FileNotFoundError:
        print(f"Error: File '{file}' not found.")
    return None

def read_nodes_from_string(data_string):
    graph = nx.DiGraph()
    cooccurrences = read_cooccurrences()
    file_like_object = io.StringIO(data_string)
    for line in file_like_object:
        line = line.strip()
        if not line or line.startswith('#'):
            continue  # Skip empty lines and comments

        parts = line.split()
        if len(parts) != 4:
            continue  # Skip lines that don't have exactly 4 elements

        node1_id, node1_name, node2_id, node2_name = parts

        if not graph.has_node(node1_id):
            graph.add_node(node1_id, name=node1_name, cooccurrences=cooccurrences[node1_name])
        if not graph.has_node(node2_id):
            graph.add_node(node2_id, name=node2_name, cooccurrences=cooccurrences[node2_name])

        graph.add_edge(node1_id, node2_id)
    
    return graph