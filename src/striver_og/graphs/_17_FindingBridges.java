package striver_og.graphs;

import java.util.ArrayList;
import java.util.List;

public class _17_FindingBridges {
    public static void dfs(int node, int parent, boolean[] vis, int[] tin, int[] tlow, List<List<Integer>> adj,
                           int counter) {
        vis[node] = true;
        tin[node] = tlow[node] = counter++;

        for (Integer iadj : adj.get(node)) {
            if (iadj == parent) {
                // We do not take the value of the parent, we just ignore it
                continue;
                // Go to another iadj
            }

            if (!vis[iadj]) {
                dfs(iadj, node, vis, tin, tlow, adj, counter);
                // This is during the backtracking so our node can only take it's child's low if
                // it is lower
                // We see who has the lower tlow value
                tlow[node] = Math.min(tlow[node], tlow[iadj]);

                if (tlow[iadj] > tin[node]) {
                    // This means that the edge between node and iadj is a bridge
                    System.out.println(iadj + "    " + node);
                }

            } else {
                // If we reach a dead end node we can take it's tin as our low
                // It was visited before us so we can take it's tin
                tlow[node] = Math.min(tin[iadj], tlow[node]);
            }
        }

    }

    public static void printBridges(List<List<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] tlow = new int[V];

        int counter = 1;
        // Normal DFS call
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, tlow, adj, counter); // Parent of an unvisited node is always -1
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        printBridges(adj, n);
    }
}
