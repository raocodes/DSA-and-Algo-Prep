package striver_og.trees;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class _34_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode temp = root;
        TreeNode prev = null;
        while (temp != null) {
            prev = temp;
            if (val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if (val > prev.val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }

        return root;
    }
}
