package striver_og.trees;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class _35_DeleteInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root;
        while (temp != null) {
            if (key < temp.val) {
                if (temp.left != null && temp.left.val == key) {
                    // We need to delete what is in temp.left
                    temp.left = helper(temp.left);
                    break;
                } else {
                    // If we do not find the node temp just becomes null
                    temp = temp.left;
                }
            } else if (key > temp.val) {
                if (temp.right != null && temp.right.val == key) {
                    // We need to delete what is in temp.right
                    temp.right = helper(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                // This means that temp is what is do be deleted
                // This happens only when root is what is to be deleted
                root = helper(temp);
                break;
            }
        }

        return root;
    }

    public TreeNode helper(TreeNode root) {
        // Root is the node to be deleted
        // This function sorts out all the subtrees and returns the root of the subtree
        if (root.left == null) {
            // left does not exist
            // We return the right as that will be attached to the prev
            return root.right;
        }

        if (root.right == null) {
            // right does not exist
            // We return the left as that will be attached to the prev
            return root.left;
        }

        // Otherwise we need to most right subtree to left's rightmost
        TreeNode rightSubTree = root.right;
        TreeNode leftSubTree = root.left;
        TreeNode whereToAdd = null;

        while (leftSubTree != null) {
            whereToAdd = leftSubTree;
            leftSubTree = leftSubTree.right;
        }

        whereToAdd.right = rightSubTree;

        return root.left;
    }
}
