package striver_og.trees;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class _3_PostOrderTraversal {
    public void postorder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }

        postorder(result, node.left);
        postorder(result, node.right);
        result.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(result, root);
        return result;
    }
}
