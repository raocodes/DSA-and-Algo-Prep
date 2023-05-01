package striver_og.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1_BFS {
    public static List<Integer> bfs(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];

        for (int i = 1; i < V; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>();

                // Mark as visited when added to queue
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll(); // Better than remove as it does not give exception
                    bfs.add(node); // Print after removing from queue

                    for (Integer iadj : adj.get(node)) {
                        if (!vis[iadj]) {
                            q.add(iadj);
                            vis[iadj] = true;
                        }
                    }

                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int n = 7;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(7);

        adj.get(3).add(2);
        adj.get(3).add(5);

        adj.get(4).add(6);

        adj.get(5).add(3);
        adj.get(5).add(7);

        adj.get(6).add(4);

        adj.get(7).add(2);
        adj.get(7).add(5);

        List<Integer> bfs = bfs(n, adj);
        for (Integer entry : bfs) {
            System.out.println(entry);
        }
    }
}
