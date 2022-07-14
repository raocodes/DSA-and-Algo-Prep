package trees_striver;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class _15_ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean goright = true;
        while (!queue.isEmpty()) {
            List<Integer> toaddinresult = new ArrayList<>();
            int sizeOfLevel = queue.size();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                toaddinresult.add(node.val);
            }
            if (!goright) {
                Collections.reverse(toaddinresult);
                goright = true;
            } else {
                goright = false;
            }

            result.add(toaddinresult);
        }

        return result;
    }
}
