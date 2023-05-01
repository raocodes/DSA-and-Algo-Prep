package striver_og.trees;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class _28_ConstructBTFromInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>(); // Contains the element's index in the array

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = create(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode create(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inMap) {

        if (postStart > postEnd || inStart > inEnd) {
            return null; // No more elements left
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(postorder[postEnd]);
        int numsOnLeft = inRoot - inStart;

        root.left = create(postorder, postStart, postStart + numsOnLeft - 1, inorder, inStart, inRoot - 1, inMap);
        root.right = create(postorder, postStart + numsOnLeft, postEnd - 1, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
