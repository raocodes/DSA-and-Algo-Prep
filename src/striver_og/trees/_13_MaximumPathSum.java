package striver_og.trees;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class _13_MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        findSum(root, max);
        return max[0];
    }

    public int findSum(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        // If it is negative then just ignore it as it is not the max
        int maxleft = Math.max(0, findSum(node.left, max));
        int maxright = Math.max(0, findSum(node.right, max));

        max[0] = Math.max(max[0], node.val + maxleft + maxright);

        return node.val + Math.max(maxleft, maxright);
    }
}
