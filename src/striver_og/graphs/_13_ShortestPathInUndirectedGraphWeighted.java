package striver_og.graphs;

import java.util.List;
import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;

// This is Dijkstra's Algorithm
public class _13_ShortestPathInUndirectedGraphWeighted {
    public static void printShortestPathDijkstra(int V, List<List<Pair>> adj, int srcnode) {
        int[] dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Creating a comparator using lambdas for the priority queue
        Comparator<Pair> paircomparator = (Pair o1, Pair o2) -> {
            if (o1.getWeight() < o2.getWeight()) {
                return -1;
            }
            if (o1.getWeight() > o2.getWeight()) {
                return 1;
            }
            return 0;
        };

        Queue<Pair> q = new PriorityQueue<>(paircomparator);
        q.add(new Pair(srcnode, 0));
        dist[srcnode] = 0;

        while (!q.isEmpty()) {
            Pair node = q.poll();

            for (Pair iadj : adj.get(node.getNode())) {
                if (dist[node.getNode()] + iadj.getWeight() < dist[iadj.getNode()]) {
                    dist[iadj.getNode()] = node.getWeight() + iadj.getWeight();
                    q.add(new Pair(iadj.getNode(), dist[iadj.getNode()]));
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
        int n = 5;
        int srcnode = 1;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(new Pair(2, 2));
        adj.get(1).add(new Pair(4, 1));

        adj.get(2).add(new Pair(1, 2));
        adj.get(2).add(new Pair(5, 5));
        adj.get(2).add(new Pair(3, 4));

        adj.get(3).add(new Pair(2, 4));
        adj.get(3).add(new Pair(4, 3));
        adj.get(3).add(new Pair(5, 1));

        adj.get(4).add(new Pair(1, 1));
        adj.get(4).add(new Pair(3, 3));

        adj.get(5).add(new Pair(2, 5));
        adj.get(5).add(new Pair(3, 1));

        printShortestPathDijkstra(n, adj, srcnode);
    }
}
