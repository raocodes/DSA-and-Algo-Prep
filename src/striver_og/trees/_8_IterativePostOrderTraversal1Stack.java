package striver_og.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class _8_IterativePostOrderTraversal1Stack {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        while (curr != null || !stk.isEmpty()) {
            if (curr != null) {
                // Keep going as right as possible
                stk.push(curr);
                curr = curr.left;
            } else {
                if (stk.peek().right == null) {
                    // If TOS element's right is null then we need to print by adding to the result
                    TreeNode temp = stk.pop();
                    result.add(temp.val);
                    // Now we go back upwards for all those whose right is curr
                    // This means that they are all to be printed too as no left
                    while (!stk.isEmpty() && stk.peek().right == temp) {
                        temp = stk.pop();
                        result.add(temp.val);
                    }
                } else {
                    // If TOS element's right is not null we again start traversal
                    curr = stk.peek().right;
                }
            }
        }

        return result;
    }
}
