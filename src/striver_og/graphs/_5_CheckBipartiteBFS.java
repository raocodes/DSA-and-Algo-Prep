package striver_og.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _5_CheckBipartiteBFS {
    public static boolean checkBipartiteBfs(int V, List<List<Integer>> adj) {
        int[] colour = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            colour[i] = -1; // Initialise all elements with -1
        }

        for (int i = 1; i <= V; i++) {
            if (colour[i] == -1) {
                Queue<Integer> q = new LinkedList<>();

                q.add(i);
                colour[i] = 0; // First element with colour 0

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (Integer iadj : adj.get(node)) {
                        if (colour[iadj] == -1) {
                            // Node has not been coloured
                            colour[iadj] = 1 - colour[node]; // Stores the opposite colour
                            q.add(iadj);
                        } else if (colour[iadj] == colour[node]) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(7);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(7).add(2);
        adj.get(7).add(6);

        adj.get(4).add(3);
        adj.get(4).add(5);


        adj.get(6).add(7);
        adj.get(6).add(5);

        adj.get(5).add(6);
        adj.get(5).add(8);

        adj.get(8).add(5);

        System.out.println("Is it bipartite: " + checkBipartiteBfs(n, adj));
    }
}
