package Striver.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _10_CycleDetectionBFSDirected {
    public static boolean checkCycleBfs(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V + 1];

        // Counting in-degree for each element
        for (int i = 1; i <= V; i++) {
            // Each adjacent node will have an in-degree
            for (int iadj : adj.get(i)) {
                indegree[iadj]++;
            }
        }

        // We do not need for loop here for components of the graph because we are loading all 0 in-degree elements
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++; // In place of topo output

            for (Integer iadj : adj.get(node)) {
                indegree[iadj]--;
                if (indegree[iadj] == 0) {
                    q.add(iadj);
                }
            }

        }
        // If there is a topological sort, the topo sort size is V. If there are more then it has a cycle
        return count != V;
    }

    public static void main(String[] args) {
        int n = 4;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(2);

        System.out.println("Is it a cycle: " + checkCycleBfs(n, adj));

    }
}
