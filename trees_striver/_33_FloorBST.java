package trees_striver;

public class _33_FloorBST {
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

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int floor = -1;
        while (root != null) {
            if (root.data == X) {
                return root.data;
            }

            if (X < root.data) {
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }

        return floor;
    }
}
