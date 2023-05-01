package striver_og.trees;

import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/
public class _41_BSTIterator {
    TreeNode root;
    Stack<TreeNode> stk;

    public _41_BSTIterator(TreeNode root) {
        this.root = root;
        TreeNode node = root;
        stk = new Stack<>();
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stk.pop();
        int toreturn = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
        }
        return toreturn;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }
}
