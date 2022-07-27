package trees_striver;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class _36_KthSmallestInBST {
    public int inorderTraversal(TreeNode root, int[] counter, int k) {
        if (root == null) {
            return -1;
        }

        int result;
        result = inorderTraversal(root.left, counter, k);
        if (result != -1) {
            return result;
        }
        counter[0]++;
        if (counter[0] == k) {
            return root.val;
        }
        result = inorderTraversal(root.right, counter, k);
        if (result != -1) {
            return result;
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        // Naive approach would be to store the entire traversal to the list
        // Sort it and take the smallest

        int[] counter = new int[] { 0 };
        return inorderTraversal(root, counter, k);
    }
}
