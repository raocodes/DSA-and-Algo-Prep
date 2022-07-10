package trees_striver;

// https://leetcode.com/problems/balanced-binary-tree/
public class _11_CheckIfBalanced {
    public int modifiedHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftheight = modifiedHeight(root.left);
        int rightheight = modifiedHeight(root.right);

        if (leftheight == -1 || rightheight == -1) {
            return -1;
        }
        if (Math.abs(leftheight - rightheight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftheight, rightheight);
    }

    public boolean isBalanced(TreeNode root) {
        if (modifiedHeight(root) == -1) {
            return false;
        }
        return true;
    }
}
