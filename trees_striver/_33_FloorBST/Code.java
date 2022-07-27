package trees_striver._33_FloorBST;

public class Code {
    public static int floorInBST(TreeNode<Integer> root, int X) {
        int floor = -1;
        while(root != null){
            if(root.data == X){
                return root.data;
            }
            
            if(X < root.data){
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        
        return floor;
    }
}
