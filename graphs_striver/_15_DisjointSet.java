package graphs_striver;

// Nodes start with 1 in this example
public class _15_DisjointSet {
    static int[] parent = new int[Integer.MAX_VALUE];
    static int[] rank = new int[Integer.MAX_VALUE];

    public static void makeSet(int size) {
        for (int i = 1; i <= size; i++) {
            parent[i] = i; // The parent of all nodes in the beginning is themselves
            rank[i] = 0;
        }
    }

    public static int findParent(int node) {
        // Finds the parent of a given node
        // Uses recursion
        if (node == parent[node]) {
            // This is it's own parent
            return node;
        }

        return parent[node] = findParent(parent[node]); // Performs path compression
    }

    public static void union(int u, int v) {
        // Creating union
        u = findParent(u);
        v = findParent(v);
        // We need their parents for evaluation

        if (rank[u] < rank[v]) {
            parent[u] = v;
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            // If their parents have the same rank
            rank[u]++;
            parent[v] = u;
        }
    }
}
