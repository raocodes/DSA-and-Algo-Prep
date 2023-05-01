package striver_og.trees;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/path-to-given-node/
public class _22_FindPathToNode {
    public boolean findPath(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return false;
        }

        path.add(node.val);

        if (node.val == target) {
            return true;
        }

        boolean left = findPath(node.left, target, path);
        // If we found in the left then return before removing from path
        if (left) {
            return true;
        }
        boolean right = findPath(node.right, target, path);
        // If we did not find in left and found in right then return path
        if (right) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        findPath(A, B, result);
        int[] toreturn = new int[result.size()];
        for (int i = 0; i < toreturn.length; i++) {
            toreturn[i] = result.get(i);
        }
        return toreturn;
    }
}
