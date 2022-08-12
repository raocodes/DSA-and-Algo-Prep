package trees_striver;

import java.util.Stack;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class _42_TwoSumInBST {
    class BSTIterator {
        Stack<TreeNode> stk;
        boolean reverse;

        public BSTIterator(TreeNode root, boolean reverse) {
            TreeNode node = root;
            this.reverse = reverse;
            this.stk = new Stack<>();
            while (node != null) {
                stk.push(node);
                if (!reverse) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }

        public int next() {
            TreeNode node = stk.pop();
            int toreturn = node.val;
            if (!reverse) {
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stk.push(node);
                        node = node.left;
                    }
                }
            } else {
                if (node.left != null) {
                    node = node.left;
                    while (node != null) {
                        stk.push(node);
                        node = node.right;
                    }
                }
            }

            return toreturn;
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

    }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = left.next();
            } else {
                j = right.next();
            }
        }

        return false;
    }
}
