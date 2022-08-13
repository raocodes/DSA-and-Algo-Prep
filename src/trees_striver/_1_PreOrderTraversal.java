package trees_striver;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class _1_PreOrderTraversal {
    public void preorder(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        preorder(result, node.left);
        preorder(result, node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(result, root);
        return result;
    }
}
