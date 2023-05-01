package striver_og.trees;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class _39_ConstructBSTFromPreOrder {
    public TreeNode create(int[] preorder, int[] index, int bound) {
        if (index[0] == preorder.length || preorder[index[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;

        root.left = create(preorder, index, root.val);
        root.right = create(preorder, index, bound);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[]{0};
        return create(preorder, index, Integer.MAX_VALUE);
    }
}
