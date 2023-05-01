package striver_og.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This example starts with 0
public class _12_ShortestPathInDirectedGraphWeighted {
    // We can use dfs or bfs to make the topo sort
    public static void dfsTopo(int node, boolean[] vis, Stack<Integer> stk, List<List<Pair>> adj) {
        vis[node] = true;

        for (Pair iadj : adj.get(node)) {
            if (!vis[iadj.getNode()]) {
                dfsTopo(iadj.getNode(), vis, stk, adj);
            }
        }
        // Before returning the recursive calls as it is done we add to stack
        stk.add(node);
    }

    public static Stack<Integer> getTopoSortDFS(int V, List<List<Pair>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsTopo(i, vis, stk, adj);
            }
        }
        return stk;
    }

    public static void printShortestPaths(int V, List<List<Pair>> adj, int srcnode) {
        Stack<Integer> stk = getTopoSortDFS(V, adj);
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[srcnode] = 0; // Source element is set to zero so that the inner condition goes through


        while (!stk.isEmpty()) {
            int node = stk.pop();

            // This is the make sure that we start with the source node
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair iadj : adj.get(node)) {
                    if (dist[node] + iadj.getWeight() < dist[iadj.getNode()]) {
                        // If the calculated distance is lower than current we change the value
                        dist[iadj.getNode()] = dist[node] + iadj.getWeight();
                    }
                }
            }
        }

        for (int entry : dist) {
            if (entry == Integer.MAX_VALUE) {
                // Some sources do not have a path to a node so we get INF in the end also
                System.out.println("INF"); // Try with src = 5 to see
            } else {
                System.out.println(entry);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int srcnode = 0;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(3, 6));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(5).add(new Pair(3, 1));

        printShortestPaths(n, adj, srcnode);
    }
}
