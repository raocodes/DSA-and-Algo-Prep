package trees_striver;

import java.util.LinkedList;
import java.util.Queue;

class QueueObj {
    TreeNode node;
    int index;

    QueueObj(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class _24_MaximumWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<QueueObj> queue = new LinkedList<>();
        queue.offer(new QueueObj(root, 0));
        while (!queue.isEmpty()) {
            int first = 0, last = 0;
            int levelsize = queue.size();
            int prev = queue.peek().index;
            for (int i = 0; i < levelsize; i++) {
                // Ensures that it is always 0
                // Cannot be 1 as for root it needs to work
                int curid = queue.peek().index - prev;
                TreeNode node = queue.peek().node;
                queue.poll();

                if (i == 0) {
                    first = curid;
                }
                if (i == levelsize - 1) {
                    last = curid;
                }

                if (node.left != null) {
                    queue.offer(new QueueObj(node.left, curid * 2 + 1));
                }

                if (node.right != null) {
                    queue.offer(new QueueObj(node.right, curid * 2 + 2));
                }
                ans = Math.max(ans, last - first + 1);
            }
        }
        return ans;
    }
}
