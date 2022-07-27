package trees_striver;

public class _38_LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int tocheckleft, tocheckright;
        if (p.val < q.val) {
            tocheckleft = p.val;
            tocheckright = q.val;
        } else {
            tocheckleft = q.val;
            tocheckright = p.val;
        }

        while (root != null) {
            if (root.val >= tocheckleft && root.val <= tocheckright) {
                break;
            } else if (root.val < tocheckleft) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return root;
    }
}
