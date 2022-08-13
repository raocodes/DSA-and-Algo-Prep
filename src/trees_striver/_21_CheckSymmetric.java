package trees_striver;

// https://leetcode.com/problems/symmetric-tree/
public class _21_CheckSymmetric {
    public boolean checkSubTree(TreeNode leftsub, TreeNode rightsub) {
        if (leftsub == null || rightsub == null) {
            return leftsub == rightsub;
        }

        if (leftsub.val != rightsub.val) {
            return false;
        }

        return checkSubTree(leftsub.left, rightsub.right) && checkSubTree(leftsub.right, rightsub.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return checkSubTree(root.left, root.right);
    }
}
