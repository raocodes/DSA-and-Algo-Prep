package striver_og.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// This example starts with 0
public class _9_TopoSortBFS {
    public static Integer[] bfsTopo(int V, List<List<Integer>> adj) {
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[V];

        // Counting in-degree for each element
        for (int i = 0; i < V; i++) {
            // Each adjacent node will have an in-degree
            for (int iadj : adj.get(i)) {
                indegree[iadj]++;
            }
        }

        // We do not need for loop here for components of the graph because we are loading all 0 in-degree elements
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (Integer iadj : adj.get(node)) {
                indegree[iadj]--;
                if (indegree[iadj] == 0) {
                    q.add(iadj);
                }
            }

        }
        return topo.toArray(new Integer[V]);
    }

    public static void main(String[] args) {
        int n = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        System.out.println("Topological sort: ");
        for (Integer elem : bfsTopo(n, adj)) {
            System.out.println(elem);
        }
    }
}
