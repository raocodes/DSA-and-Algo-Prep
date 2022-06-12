package graphs_striver;

import java.util.ArrayList;
import java.util.List;

public class _4_CycleDetectionDFS {
    public static boolean dfsWithDetection(int node, int prev, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (Integer iadj : adj.get(node)) {
            if (!vis[iadj]) {
                if (dfsWithDetection(iadj, node, vis, adj)) return true;
            } else if (iadj != prev) return true;
        }
        return false;
    }

    public static boolean checkCycleDfs(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                if (dfsWithDetection(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 11;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(1).add(3);

        adj.get(2).add(5);

        adj.get(3).add(1);
        adj.get(3).add(4);

        adj.get(4).add(3);

        adj.get(5).add(2);
        adj.get(5).add(6);
        adj.get(5).add(8);


        adj.get(6).add(5);
        adj.get(6).add(7);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(7);
        adj.get(8).add(5);

        System.out.println("Is it a cycle: " + checkCycleDfs(n, adj));
    }
}
