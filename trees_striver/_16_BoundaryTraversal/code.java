package trees_striver._16_BoundaryTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Code {
    public static boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void leftboundary(TreeNode node, ArrayList<Integer> result) {
        TreeNode currNode = node.left;
        while (currNode != null) {
            if (isLeaf(currNode) == false) {
                result.add(currNode.data);
            }
            if (currNode.left != null) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
    }

    public static void leafnodes(TreeNode node, ArrayList<Integer> result) {
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        if (node.left != null) {
            leafnodes(node.left, result);
        }
        if (node.right != null) {
            leafnodes(node.right, result);
        }
    }

    public static void rightboundary(TreeNode node, ArrayList<Integer> result) {
        Stack<Integer> temp = new Stack<>();
        TreeNode currNode = node.right;
        while (currNode != null) {
            if (isLeaf(currNode) == false) {
                temp.push(currNode.data);
            }
            if (currNode.right != null) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }

        while (!temp.isEmpty()) {
            result.add(temp.pop());
        }
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.data);
        if (isLeaf(root)) {
            return result;
        }
        leftboundary(root, result);
        leafnodes(root, result);
        rightboundary(root, result);
        return result;
    }
}
