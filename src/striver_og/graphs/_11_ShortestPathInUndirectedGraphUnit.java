package striver_og.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _11_ShortestPathInUndirectedGraphUnit {
    public static int[] shortestPath(int V, List<List<Integer>> adj, int srcnode) {
        int[] dist = new int[V + 1];
        // Initialise all values to int max
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> q = new LinkedList<>();
        // Add source to the queue first
        q.add(srcnode);
        dist[srcnode] = 0;

        while (!q.isEmpty()) {
            Integer node = q.poll();

            for (Integer iadj : adj.get(node)) {
                if (dist[iadj] > dist[node] + 1) {
                    dist[iadj] = dist[node] + 1;
                    q.add(iadj);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 8;
        int srcnode = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(0).add(1);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(6);

        adj.get(3).add(0);
        adj.get(3).add(4);

        adj.get(4).add(3);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(6);

        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(6);
        adj.get(8).add(7);

        System.out.println("Shortest path from " + srcnode + ":");
        int[] result = shortestPath(n, adj, srcnode);
        for (int entry : result) {
            System.out.println(entry);
        }
    }
}
