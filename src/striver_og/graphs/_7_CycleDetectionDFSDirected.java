package striver_og.graphs;

import java.util.ArrayList;
import java.util.List;

public class _7_CycleDetectionDFSDirected {
    public static boolean dfsWithDetection(int node, boolean[] vis, boolean[] dfsvis, List<List<Integer>> adj) {
        vis[node] = true;
        dfsvis[node] = true;
        for (Integer iadj : adj.get(node)) {
            if (!vis[iadj]) {
                if (dfsWithDetection(iadj, vis, dfsvis, adj)) return true;
            } else if (dfsvis[iadj])
                // If the adjacent node was visited in the current traversal then it is a cycle
                return true;
        }
        // Before returning the recursive calls I reset the dfsvis
        // So that for the new set of recursive dfsvis will be 0 for these nodes
        // 'false' tells the code that it was not visited in this traversal
        dfsvis[node] = false;
        return false;
    }

    public static boolean checkCycleDfs(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        boolean[] dfsvis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                if (dfsWithDetection(i, vis, dfsvis, adj)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 9;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(6);
        adj.get(4).add(5);
        adj.get(6).add(5);

        adj.get(7).add(2);
        adj.get(7).add(8);
        adj.get(8).add(9);
        adj.get(9).add(7);

        System.out.println("Is it a cycle: " + checkCycleDfs(n, adj));
    }
}
