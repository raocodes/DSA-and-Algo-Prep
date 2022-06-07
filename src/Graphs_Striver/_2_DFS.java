package Graphs_Striver;

import java.util.ArrayList;
import java.util.List;

public class _2_DFS {
    public static void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> storeDfs) {
        // Mark as visited when call is made
        // Print when call is made
        storeDfs.add(node);
        vis[node] = true;
        for (Integer iadj : adj.get(node)) {
            // Going through all adjacent nodes
            if (!vis[iadj]) {
                dfs(iadj, vis, adj, storeDfs);
            }
        }
    }

    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, storeDfs);
            }
        }
        return storeDfs;
    }

    public static void main(String[] args) {
        int n = 7;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(7);

        adj.get(3).add(5);

        adj.get(4).add(2);
        adj.get(4).add(6);

        adj.get(5).add(3);

        adj.get(6).add(4);
        adj.get(6).add(7);

        adj.get(7).add(2);
        adj.get(7).add(6);

        List<Integer> dfs = dfsOfGraph(n, adj);
        for (Integer entry : dfs) {
            System.out.println(entry);
        }
    }
}
