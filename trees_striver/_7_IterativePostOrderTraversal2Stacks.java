package trees_striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class _7_IterativePostOrderTraversal2Stacks {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        stk1.add(root);

        while (!stk1.isEmpty()) {
            stk2.add(stk1.pop());
            if (stk2.peek().left != null) {
                stk1.add(stk2.peek().left);
            }
            if (stk2.peek().right != null) {
                stk1.add(stk2.peek().right);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stk2.isEmpty()) {
            result.add(stk2.pop().val);
        }

        return result;
    }
}
