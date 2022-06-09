package Graphs_Striver;

import java.util.ArrayList;
import java.util.List;

// This example starts with 0
public class _14_PrimsAlgorithmBrute {
    public static void primsAlgo(int V, List<List<Pair>> adj) {
        int[] key = new int[V];
        boolean[] mst = new boolean[V];
        int[] parent = new int[V];

        // Initialise all the values in the arrays
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
            parent[i] = -1;
        }

        // Start with first key as 0
        key[0] = 0;

        // We do the loop only n - 1 times because a spanning tree has n - 1 edges and n
        // vertices
        for (int i = 0; i < V; i++) {
            // We first find the smallest key
            int smallval = Integer.MAX_VALUE;
            int smallindex = 0;

            for (int j = 0; j < V; j++) {
                if (key[i] < smallval) {
                    smallval = key[i];
                    smallindex = i;
                }
            }

            for (Pair iadj : adj.get(smallindex)) {
                if (mst[iadj.getNode()] == false && iadj.getWeight() < key[iadj.getNode()]) {
                    key[iadj.getNode()] = iadj.getWeight(); // Change key value as it is lower
                    parent[iadj.getNode()] = smallindex; // Add parent afrer changing value
                }
            }
        }

        System.out.println("MST:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "    -    " + parent[i]);
        }
    }

    public static void main(String[] args) {
        int n = 5;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(3, 6));

        adj.get(1).add(new Pair(0, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 8));
        adj.get(1).add(new Pair(4, 5));

        adj.get(2).add(new Pair(1, 3));
        adj.get(2).add(new Pair(4, 7));

        adj.get(3).add(new Pair(0, 6));
        adj.get(3).add(new Pair(1, 8));

        adj.get(4).add(new Pair(1, 5));
        adj.get(4).add(new Pair(2, 7));

        primsAlgo(n, adj);
    }

}
