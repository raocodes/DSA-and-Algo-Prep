package trees_striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class _5_IterativePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stk = new Stack<>();
        List<Integer> result = new ArrayList<>();

        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            result.add(node.val);
            if (node.right != null) {
                stk.add(node.right);
            }
            if (node.left != null) {
                stk.add(node.left);
            }
        }

        return result;
    }
}
