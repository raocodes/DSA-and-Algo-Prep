package striver_og.trees;

// https://leetcode.com/problems/same-tree/
public class _14_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
            // Sometimes they both can
        }

        if (p.val != q.val) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }

        return true;
    }
}
