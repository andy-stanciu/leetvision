import torch
import tqdm
import joblib
from sklearn.decomposition import PCA

class KNNClassifier:
    def __init__(self, embedding_method=None, k=1, pca_dim=128, max_nodes=512):
        """
        Args:
            embedding_method (callable, optional): A function that takes a graph Data object
                and returns a 2D tensor of shape [1, d] as its embedding. If None, a default
                embedding method that concatenates node features (with truncation/padding) is used.
            k (int): Number of nearest neighbors.
            pca_dim (int): Target dimensionality for the graph-level PCA.
            max_nodes (int): Fixed number of nodes per graph (for truncation/padding).
        """
        self.k = k
        self.pca_dim = pca_dim
        self.max_nodes = max_nodes
        
        self.embedding_method = embedding_method
        self.train_embeddings = None  # Graph-level PCA-transformed embeddings.
        self.train_labels = None      # Tensor of shape [N]
        self.pca = None             # Graph-level PCA (fitted on concatenated embeddings).
    
    def update_k(self, new_k):
        """Update the number of nearest neighbors used at inference time."""
        self.k = new_k
    
    def get_embedding(self, data):
        """
        Get the graph-level raw embedding using the provided embedding method.
        
        Args:
            data: A torch_geometric Data object.
        
        Returns:
            torch.Tensor: A tensor of shape [1, d] representing the embedding.
        """
        return self.embedding_method(data)
    
    def fit(self, loader):
        """
        Fit the KNN classifier by computing graph-level raw embeddings for the training set,
        then fitting a PCA model to reduce their dimensionality.
        
        Args:
            loader: A DataLoader that yields graph Data objects (assumed batch size = 1).
        """
        embeddings = []
        labels = []
        for batch in tqdm(loader, desc="Fitting"):
            if batch is None or batch.x.size(0) == 0:
                continue
            emb = self.get_embedding(batch)  # Expected shape: [1, d]
            # If batch contains more than one graph (unlikely with batch_size=1),
            # iterate over them.
            for i in range(emb.size(0)):
                embeddings.append(emb[i].unsqueeze(0))
                labels.append(batch.y[i].item())
        if embeddings:
            raw_embeddings = torch.cat(embeddings, dim=0)  # Shape: [N, d]
            self.train_labels = torch.tensor(labels, dtype=torch.long)
            raw_np = raw_embeddings.cpu().numpy()
            self.pca = PCA(n_components=self.pca_dim)
            transformed = self.pca.fit_transform(raw_np)
            self.train_embeddings = torch.tensor(transformed, dtype=torch.float)
        else:
            self.train_embeddings = torch.empty((0, self.pca_dim))
            self.train_labels = torch.empty((0,), dtype=torch.long)
    
    def predict(self, data, metric="cosine", top_c=1):
        """
        Predict the top c label(s) for one or more graphs.
        
        Args:
            data: A torch_geometric Data object (or batch) for which to predict labels.
            metric (str): Similarity metric to use. Options are "cosine" (default),
                        "manhattan", or "euclidean".
            top_c (int): Number of top predicted labels to return per sample (c <= k).
            
        Returns:
            torch.Tensor: A tensor of shape [B, top_c] containing the top c predicted labels
                        for each graph.
        """
        embeddings_raw = self.get_embedding(data)  # Expected shape: [B, d]
        if self.pca is None:
            return torch.zeros((embeddings_raw.size(0), top_c), dtype=torch.long)
        
        embeddings_np = embeddings_raw.cpu().detach().numpy()
        if embeddings_np.ndim == 1:
            embeddings_np = embeddings_np.reshape(1, -1)
        
        transformed_np = self.pca.transform(embeddings_np)  # Shape: [B, pca_dim]
        embeddings_transformed = torch.tensor(transformed_np, dtype=torch.float)
        
        if self.train_embeddings.size(0) == 0:
            return torch.zeros((embeddings_transformed.size(0), top_c), dtype=torch.long)
        
        # Compute pairwise distances using the specified metric.
        if metric == "euclidean":
            dists = torch.cdist(embeddings_transformed, self.train_embeddings, p=2)
        elif metric == "manhattan":
            dists = torch.cdist(embeddings_transformed, self.train_embeddings, p=1)
        elif metric == "cosine":
            # Normalize to compute cosine similarity.
            q_norm = embeddings_transformed / embeddings_transformed.norm(dim=1, keepdim=True)
            t_norm = self.train_embeddings / self.train_embeddings.norm(dim=1, keepdim=True)
            similarity = torch.mm(q_norm, t_norm.t())
            dists = 1 - similarity
        else:
            raise ValueError(f"Unsupported metric: {metric}")
        
        batch_preds = []
        for i in range(dists.size(0)):
            dist = dists[i]
            # Get indices of the k nearest neighbors.
            knn_indices = torch.topk(dist, self.k, largest=False).indices
            knn_labels = self.train_labels[knn_indices].flatten().long()
            if knn_labels.numel() == 0 or (knn_labels < 0).any():
                batch_preds.append([0] * top_c)
            else:
                counts = torch.bincount(knn_labels)
                # Retrieve top_c labels by vote count.
                num_available = counts.size(0)
                num_to_get = min(top_c, num_available)
                top_counts, top_labels = torch.topk(counts, num_to_get, largest=True)
                pred_labels = top_labels.tolist()
                # If there are fewer than top_c unique labels, pad with zeros.
                if len(pred_labels) < top_c:
                    pred_labels += [0] * (top_c - len(pred_labels))
                batch_preds.append(pred_labels)
        return torch.tensor(batch_preds)


def load_knn(file_prefix, embedding_method, pca_dim=194, max_nodes=512, verbose=False):
    """
    Load a KNNClassifier from previously saved training data.
    This method loads:
      - '{file_prefix}_embeddings.pt'
      - '{file_prefix}_labels.pt'
      - '{file_prefix}_pca.joblib' (if available)
      
    After loading, it filters out any training examples whose label is -1.
    
    Returns:
        An instance of KNNClassifier with the loaded data.
    """
    instance = KNNClassifier(k=1, embedding_method=embedding_method, pca_dim=pca_dim, max_nodes=max_nodes)
    try:
        instance.train_embeddings = torch.load(f"{file_prefix}_embeddings.pt")
        instance.train_labels = torch.load(f"{file_prefix}_labels.pt")
        instance.pca = joblib.load(f"{file_prefix}_pca.joblib")
        
        # Filter out training examples with label -1.
        valid_mask = instance.train_labels != -1
        instance.train_labels = instance.train_labels[valid_mask]
        instance.train_embeddings = instance.train_embeddings[valid_mask]
        
        if verbose:
            print(f"Loaded embeddings, labels, and PCA model from '{file_prefix}'.")
            print(f"Kept {instance.train_labels.size(0)} valid training examples (removed {torch.sum(~valid_mask).item()} examples with label -1).")
    except Exception as e:
        print("Error loading saved KNN data:", e)
    return instance