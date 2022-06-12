package graphs_striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// This example has from 0
public class _16_KruskalsAlgorithm {
    public static int findParent(int node, int[] parent) {
        // Finds the parent of a given node
        // Uses recursion
        if (node == parent[node]) {
            // This is it's own parent
            return node;
        }

        return parent[node] = findParent(parent[node], parent); // Performs path compression
    }

    public static void union(int u, int v, int[] parent, int[] rank) {
        // Creating union
        u = findParent(u, parent);
        v = findParent(v, parent);
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

    public static void kurskalAlgo(ArrayList<Node> adj, int n) {
        // We sort the adjacency list to be greedy
        Comparator<Node> nodecompare = (Node n1, Node n2) -> {
            if (n1.getWeight() < n2.getWeight())
                return -1;
            if (n1.getWeight() > n2.getWeight())
                return 1;
            return 0;
        };

        Collections.sort(adj, nodecompare);

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 1; i < n; i++) {
            parent[i] = i; // The parent of all nodes in the beginning is themselves
            rank[i] = 0;
        }

        int costMST = 0; // Total cost of MST (Sum of weighted edges)

        ArrayList<Node> mst = new ArrayList<>();
        for (Node node : adj) {
            // Iterating through the adj list
            if (findParent(node.getU(), parent) != findParent(node.getV(), parent)) {
                // They do not belong to the same component
                costMST += node.getWeight();
                mst.add(node);
                union(node.getU(), node.getV(), parent, rank);
            }
        }

        System.out.println("MST:");
        for (Node node : mst) {
            System.out.println(node.getU() + "  " + node.getV());
        }
        System.out.println("Cost of MST: " + costMST);
    }

    public static void main(String[] args) {
        int n = 5;
        // Our own linear data structure
        ArrayList<Node> adj = new ArrayList<>();

        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));

        kurskalAlgo(adj, n);
    }
}
