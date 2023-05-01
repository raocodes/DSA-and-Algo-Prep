package striver_og.trees;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class _26_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = 1;
        TreeNode temp = root.left;
        while (temp != null) {
            lh++;
            temp = temp.left;
        }

        int rh = 1;
        temp = root.right;
        while (temp != null) {
            rh++;
            temp = temp.right;
        }

        if (rh == lh) {
            return (int) Math.pow(2, rh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
