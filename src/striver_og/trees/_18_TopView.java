package striver_og.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class _18_TopView {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class NodeObj {
        Node node;
        int vertical;

        NodeObj(Node node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<NodeObj> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new NodeObj(root, 0));

        while (!queue.isEmpty()) {
            NodeObj nodeobj = queue.poll();
            int vertical = nodeobj.vertical;
            Node node = nodeobj.node;

            if (!map.containsKey(vertical)) {
                map.put(vertical, node.data);
            }

            if (node.left != null) {
                queue.add(new NodeObj(node.left, vertical - 1));
            }

            if (node.right != null) {
                queue.add(new NodeObj(node.right, vertical + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
