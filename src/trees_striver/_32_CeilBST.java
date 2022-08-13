package trees_striver;

// https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=1
public class _32_CeilBST {
    public class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = -1;
        while (node != null) {
            if (node.data == x) {
                return node.data;
            }

            if (x < node.data) {
                ceil = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return ceil;
    }
}
