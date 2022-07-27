package trees_striver._32_CeilBST;

// https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=1
public class Code {
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
