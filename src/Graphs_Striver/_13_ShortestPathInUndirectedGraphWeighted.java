package Graphs_Striver;

import java.util.*;

// Created a PairComp object because this is a weighted graph
class PairComp implements Comparator<PairComp> {
    private int node;
    private int weight;

    public PairComp(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public PairComp() {
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    public int compare(PairComp o1, PairComp o2) {
        if (o1.getWeight() < o2.getWeight()) {
            return -1;
        }
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        }
        return 0;
    }
}

// This is Dijkstra's Algorithm
public class _13_ShortestPathInUndirectedGraphWeighted {
    public static void printShortestPathDijkstra(int V, List<List<PairComp>> adj, int srcnode) {
        int[] dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<PairComp> q = new PriorityQueue<>(new PairComp());
        q.add(new PairComp(srcnode, 0));
        dist[srcnode] = 0;

        while (!q.isEmpty()) {
            PairComp node = q.poll();

            for (PairComp iadj : adj.get(node.getNode())) {
                if (dist[node.getNode()] + iadj.getWeight() < dist[iadj.getNode()]) {
                    dist[iadj.getNode()] = node.getWeight() + iadj.getWeight();
                    q.add(new PairComp(iadj.getNode(), dist[iadj.getNode()]));
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

        List<List<PairComp>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(new PairComp(2, 2));
        adj.get(1).add(new PairComp(4, 1));

        adj.get(2).add(new PairComp(1, 2));
        adj.get(2).add(new PairComp(5, 5));
        adj.get(2).add(new PairComp(3, 4));

        adj.get(3).add(new PairComp(2, 4));
        adj.get(3).add(new PairComp(4, 3));
        adj.get(3).add(new PairComp(5, 1));

        adj.get(4).add(new PairComp(1, 1));
        adj.get(4).add(new PairComp(3, 3));

        adj.get(5).add(new PairComp(2, 5));
        adj.get(5).add(new PairComp(3, 1));

        printShortestPathDijkstra(n, adj, srcnode);
    }
}
