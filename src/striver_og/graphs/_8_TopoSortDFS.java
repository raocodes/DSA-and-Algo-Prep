package striver_og.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This example starts with 0
public class _8_TopoSortDFS {
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

    public static Integer[] getTopoSortDFS(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsTopo(i, vis, stk, adj);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!stk.isEmpty()) {
            res.add(stk.pop());
        }

        // To test conversion
        return res.toArray(new Integer[adj.size()]);
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
        for (Integer elem : getTopoSortDFS(n, adj)) {
            System.out.println(elem);
        }
    }
}
