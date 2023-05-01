package striver_og.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class _6_IterativeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode currnode = root;
        while (true) {
            if (currnode != null) {
                // Go left and add node to stack
                stk.add(currnode);
                currnode = currnode.left;
            } else {
                if (stk.isEmpty()) {
                    // Stack is empty so there is nothing to pop and current is null
                    break;
                } else {
                    currnode = stk.pop();
                    result.add(currnode.val);
                    currnode = currnode.right;
                }
            }
        }

        return result;
    }
}
