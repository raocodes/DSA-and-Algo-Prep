package trees_striver;

// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
public class _40_PredecessorSuccessorBST {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Res {
        Node pre = null;
        Node succ = null;
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        Node node = root;
        while (node != null) {
            if (node.data > key) {
                s.succ = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        node = root;
        while (node != null) {
            if (node.data >= key) {
                node = node.left;
            } else {
                p.pre = node;
                node = node.right;
            }
        }
    }
}
