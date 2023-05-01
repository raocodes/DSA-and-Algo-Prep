package striver_og.graphs;

import java.util.ArrayList;
import java.util.List;

// This example has from 0
public class _20_BellmanFordAlgorithm {
    public static void bellmanFord(List<Node> adj, int V, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE - 1000; // Overflow happens otherwise as sum is taken
        }
        dist[src] = 0;

        // n - 1 iteration which is needed because as per bellman ford. n - 1 is the
        // longest possible path and therefore all values should be updated by then.
        // This is especially because only one starts with 0 and the rest with max
        for (int i = 0; i < V - 1; i++) {
            for (Node node : adj) {
                if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        // Performing one more iteration to see if distances change. If they change then
        // there is a negative cycle as only then we can it change even afer n - 1 times
        for (Node node : adj) {
            if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                System.out.println("Negative cycle detected!");
                return;
            }
        }

        // If the above loop did not return then there is no negative cycle
        // We display shortest path
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + "    ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<Node> adj = new ArrayList<>();

        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));

        // For negative cycle
        // adj.add(new Node(5, 0, -8));

        bellmanFord(adj, n, 0);
    }
}
