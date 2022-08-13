package trees_striver;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class _27_ConstructBTFromInOrderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>(); // Contains the element's index in the array

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = create(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode create(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null; // No more elements left
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(preorder[preStart]);
        int numsOnLeft = inRoot - inStart;

        root.left = create(preorder, preStart + 1, preStart + numsOnLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = create(preorder, preStart + numsOnLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
