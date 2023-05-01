package striver_og.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/clone-graph/
public class _0_CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        Node result = new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, result);

        HashSet<Node> visited = new HashSet<>();
        visited.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbour : curr.neighbors) {
                if (!visited.contains(neighbour)) {
                    q.offer(neighbour);
                    visited.add(neighbour);
                }

                Node parent = map.get(curr);
                Node child;
                if (map.containsKey(neighbour)) {
                    child = map.get(neighbour);
                } else {
                    child = new Node(neighbour.val);
                    map.put(neighbour, child);
                }
                parent.neighbors.add(child);
            }
        }

        return result;
    }
}
