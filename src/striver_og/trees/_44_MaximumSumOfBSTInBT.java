package striver_og.trees;

public class _44_MaximumSumOfBSTInBT {
    class Info {
        int largest;
        int smallest;
        int sum;

        Info(int largest, int smallest, int sum) {
            this.largest = largest;
            this.smallest = smallest;
            this.sum = sum;
        }
    }

    int sum = 0;

    public Info postorder(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Info left = postorder(root.left);
        Info right = postorder(root.right);

        if (left.largest < root.val && right.smallest > root.val) {
            sum = Math.max(left.sum + right.sum + root.val, sum);
            // We use math.min and math.max in case it is the only element in BST
            return new Info(Math.max(root.val, right.largest),
                    Math.min(root.val, left.smallest),
                    left.sum + right.sum + root.val);
        } else {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
    }

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return sum;
    }
}
