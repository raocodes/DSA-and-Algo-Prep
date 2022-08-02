package trees_striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class _19_BottomView {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class NodeObj {
        Node node;
        int vertical;

        NodeObj(Node node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<NodeObj> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new NodeObj(root, 0));

        while (!queue.isEmpty()) {
            NodeObj nodeobj = queue.poll();
            int vertical = nodeobj.vertical;
            Node node = nodeobj.node;

            map.put(vertical, node.data);

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
