package trees_striver;

// https://leetcode.com/problems/recover-binary-search-tree/
public class _43_RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode store;
    TreeNode prev;

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev.val > node.val) {
            if (first == null) {
                // This is the first violation
                first = prev;
                store = node;
            } else {
                // This is the second violation
                second = node;
            }
        }

        prev = node;
        inorder(node.right);
    }

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE); // The first element we find should not be flagged immediately
        inorder(root);

        if (first == null) {
            // No issues found
            return;
        } else if (first != null && second == null) {
            // Only first violation exists
            int temp = first.val;
            first.val = store.val;
            store.val = temp;
        } else {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
