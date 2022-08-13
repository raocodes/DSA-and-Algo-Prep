package graphs_striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _19_KosarajuAlgorithm {
    public static void dfsTopo(int node, boolean[] vis, Stack<Integer> stk, List<List<Integer>> adj) {
        vis[node] = true;

        for (Integer iadj : adj.get(node)) {
            if (!vis[iadj]) {
                dfsTopo(iadj, vis, stk, adj);
            }
        }
        // Before returning the recursive calls as it is done we add to stack
        stk.add(node);
    }

    public static void reverseDFS(int node, boolean[] vis, List<List<Integer>> transposeAdj) {
        vis[node] = true;

        System.out.print(node + "    ");

        for (Integer iadj : transposeAdj.get(node)) {
            if (!vis[iadj]) {
                reverseDFS(iadj, vis, transposeAdj);
            }
        }
    }

    public static void printStronglyConnected(List<List<Integer>> adj, int V) {
        boolean[] vis = new boolean[V + 1];
        Stack<Integer> stk = new Stack<>();

        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                // Perform a sort that is similar to topo.
                // It is not topo because cycles are allowed
                dfsTopo(i, vis, stk, adj);
            }
        }

        // Now the stack contains the sort
        // We need to transpose the graph

        List<List<Integer>> transposeAdj = new ArrayList<>();

        for (int i = 0; i <= V; i++)
            transposeAdj.add(new ArrayList<Integer>());

        for (int i = 1; i <= V; i++) {
            // Reset visited array
            vis[i] = false;
            for (Integer iadj : adj.get(i)) {
                // For every node between i -> iadj
                // We change it to iadj -> i
                transposeAdj.get(iadj).add(i);
            }
        }

        System.out.println("SCC in the graph:");
        // Now iterate through the stack
        while (!stk.isEmpty()) {
            int node = stk.pop();
            if (!vis[node]) {
                reverseDFS(node, vis, transposeAdj);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(2).add(4);
        adj.get(4).add(5);

        printStronglyConnected(adj, n);
    }
}
