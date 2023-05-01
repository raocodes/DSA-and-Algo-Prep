package striver_og.trees;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class _2_InOrderTraversal {
    public void inorder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(result, node.left);
        result.add(node.val);
        inorder(result, node.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }
}
