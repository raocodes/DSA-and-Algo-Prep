package striver_og.graphs;

import java.util.ArrayList;
import java.util.List;

public class _6_CheckBipartiteDFS {

    public static boolean dfsWithDetection(int node, int[] colour, List<List<Integer>> adj) {
        if (colour[node] == -1) colour[node] = 0; // The first ever element in the traversal

        for (Integer iadj : adj.get(node)) {
            if (colour[iadj] == -1) {
                // Node has never been visited
                // We give it a colour before doing the next call
                colour[iadj] = 1 - colour[node]; // Opposite colour to current
                if (!dfsWithDetection(iadj, colour, adj)) {
                    return false;
                }
            } else if (colour[iadj] == colour[node]) return false;
        }
        return true;
    }

    public static boolean checkBipartiteDfs(int V, List<List<Integer>> adj) {
        int[] colour = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            colour[i] = -1;
        }

        for (int i = 1; i <= V; i++) {
            if (colour[i] == -1) {
                // Node has not been coloured
                if (!dfsWithDetection(i, colour, adj)) return false;
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
        adj.get(2).add(6);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(3);
        adj.get(4).add(5);

        adj.get(6).add(2);
        adj.get(6).add(5);

        adj.get(5).add(6);
        adj.get(5).add(4);
        adj.get(5).add(7);

        adj.get(7).add(5);
        adj.get(7).add(8);

        adj.get(8).add(7);

        System.out.println("Is it bipartite: " + checkBipartiteDfs(n, adj));
    }
}
