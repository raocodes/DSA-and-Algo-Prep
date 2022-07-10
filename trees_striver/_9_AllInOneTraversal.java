package trees_striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    BinaryTreeNode<Integer> node;
    int num;

    Pair(BinaryTreeNode<Integer> node, int num) {
        this.node = node;
        this.num = num;
    }
}

// https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class _9_AllInOneTraversal {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, 1));

        while (!stk.isEmpty()) {
            Pair top = stk.pop();
            if (top.num == 1) {
                preorder.add(top.node.data);
                top.num++;
                stk.push(top);
                if (top.node.left != null) {
                    stk.push(new Pair(top.node.left, 1));
                }
            } else if (top.num == 2) {
                inorder.add(top.node.data);
                top.num++;
                stk.push(top);
                if (top.node.right != null) {
                    stk.push(new Pair(top.node.right, 1));
                }
            } else {
                postorder.add(top.node.data);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(inorder);
        result.add(preorder);
        result.add(postorder);
        return result;
    }
}
