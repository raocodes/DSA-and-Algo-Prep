package graphs_striver;

import java.util.ArrayList;
import java.util.List;

public class _18_FindingArticulationPoint {
    public static void dfs(int node, int parent, boolean[] vis, int[] tin, int[] tlow, List<List<Integer>> adj,
                           int counter, boolean[] isArticulation) {
        vis[node] = true;
        tin[node] = tlow[node] = counter++;
        int countIndiviualChild = 0;

        for (Integer iadj : adj.get(node)) {
            if (iadj == parent) {
                // We do not take the value of the parent, we just ignore it
                continue;
                // Go to another iadj
            }

            if (!vis[iadj]) {
                dfs(iadj, node, vis, tin, tlow, adj, counter, isArticulation);
                // This is during the backtracking so our node can only take it's child's low if
                // it is lower
                // We see who has the lower tlow value
                tlow[node] = Math.min(tlow[node], tlow[iadj]);

                if (tlow[iadj] >= tin[node] && parent != -1) {
                    // This means that the node is an articulation point
                    isArticulation[node] = true;
                }
                // If this is allowed to happen twice, then there are 2 independent children
                // because this is a DFS. If the first adjacent does not cause the 2nd to be
                // marked as visited, then they are not connected. So they are independent
                countIndiviualChild++;
            } else {
                // If we reach a dead end node we can take it's tin as our low
                // It was visited before us so we can take it's tin
                tlow[node] = Math.min(tin[iadj], tlow[node]);
            }
            if (parent == -1 && countIndiviualChild > 1)
                isArticulation[node] = true;
            // This means that the parent has 2 or more children so it can be an
            // articulation point
        }
    }

    public static void printArticulation(List<List<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] tlow = new int[V];

        boolean[] isArticulation = new boolean[V];

        int counter = 1;
        // Normal DFS call
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, tlow, adj, counter, isArticulation); // Parent of an unvisited node is always -1
            }
        }

        System.out.println("Articulation points:");
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                System.out.println(i);
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

        printArticulation(adj, n);
    }
}
