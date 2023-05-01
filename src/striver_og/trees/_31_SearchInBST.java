package striver_og.trees;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class _31_SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }
}
