package trees_striver;

// https://leetcode.com/problems/validate-binary-search-tree/
public class _37_ValidateBST {
    public boolean inorder(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (!inorder(node.left, min, node.val)) {
            return false;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        if (!inorder(node.right, node.val, max)) {
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        // Naive approach would be to find inorder traversal and see if is in ascending
        // order
        // Better than that we give each node a range in which it's value must be
        // Long is used because with int it is giving overflow
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
