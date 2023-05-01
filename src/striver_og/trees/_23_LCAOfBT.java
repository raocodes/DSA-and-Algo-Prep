package striver_og.trees;

import java.util.ArrayList;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class _23_LCAOfBT {
    public boolean findPath(TreeNode node, int target, ArrayList<TreeNode> path) {
        if (node == null) {
            return false;
        }

        path.add(node);

        if (node.val == target) {
            return true;
        }

        boolean left = findPath(node.left, target, path);
        // If we found in the left then return before removing from path
        if (left) {
            return true;
        }
        boolean right = findPath(node.right, target, path);
        // If we did not find in left and found in right then return path
        if (right) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> resultp = new ArrayList<>();
        findPath(root, p.val, resultp);
        ArrayList<TreeNode> resultq = new ArrayList<>();
        findPath(root, q.val, resultq);
        int size = Math.min(resultp.size(), resultq.size());

        int i;
        for (i = 0; i < size; i++) {
            if (resultq.get(i) != resultp.get(i)) {
                break;
            }
        }

        return resultq.get(i - 1);
    }
}
