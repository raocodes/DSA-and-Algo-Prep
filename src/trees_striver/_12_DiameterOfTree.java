package trees_striver;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class _12_DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        modifiedHeight(root, max);
        return max[0];
    }

    public int modifiedHeight(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int lh = modifiedHeight(root.left, max);
        int rh = modifiedHeight(root.right, max);

        max[0] = Math.max(max[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
