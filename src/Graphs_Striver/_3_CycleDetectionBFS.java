package Graphs_Striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_CycleDetectionBFS {
    public static boolean checkCycleBfs(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                Queue<Integer[]> q = new LinkedList<>();

                q.add(new Integer[]{i, -1});
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer[] temp = q.poll();
                    int node = temp[0];
                    int prev = temp[1];

                    for (Integer iadj : adj.get(node)) {
                        if (!vis[iadj]) {
                            q.add(new Integer[]{iadj, node});
                            vis[iadj] = true;
                        } else if (iadj != prev) {
                            return true;
                        }
                    }
                }
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


        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(4);

        adj.get(3).add(5);

        adj.get(4).add(2);

        adj.get(5).add(3);
        adj.get(5).add(6);
        adj.get(5).add(10);


        adj.get(6).add(5);
        adj.get(6).add(7);


        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(7);
        adj.get(8).add(9);
        adj.get(8).add(11);

        adj.get(9).add(10);
        adj.get(9).add(8);

        adj.get(10).add(5);
        adj.get(10).add(9);

        adj.get(11).add(8);

        System.out.println("Is it a cycle: " + checkCycleBfs(n, adj));
    }
}
