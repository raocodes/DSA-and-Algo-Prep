package striver_og.graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

public class _14_PrimsAlgorithmPQ {
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

        Comparator<Pair> paircompare = (Pair o1, Pair o2) -> {
            if (o1.getWeight() < o2.getWeight())
                return -1;
            else if (o1.getWeight() > o2.getWeight())
                return 1;
            else
                return 0;
        };

        Queue<Pair> pq = new PriorityQueue<>(paircompare);
        key[0] = 0;
        pq.add(new Pair(0, key[0]));

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            mst[node.getNode()] = true;

            for (Pair iadj : adj.get(node.getNode())) {
                if (mst[iadj.getNode()] == false && iadj.getWeight() < key[iadj.getNode()]) {
                    key[iadj.getNode()] = iadj.getWeight(); // Change key value as it is lower
                    parent[iadj.getNode()] = node.getNode(); // Add parent afrer changing value
                    pq.add(new Pair(iadj.getNode(), iadj.getWeight())); // Add to priority queue for quick finding
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
