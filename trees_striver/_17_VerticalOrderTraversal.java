package trees_striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map;

class NodeObj {
    TreeNode node;
    int level;
    int vertical;

    NodeObj(TreeNode node, int level, int vertical) {
        this.node = node;
        this.level = level;
        this.vertical = vertical;
    }
}

public class _17_VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<NodeObj> queue = new LinkedList<>();
        queue.offer(new NodeObj(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeObj curr = queue.poll();
            TreeNode node = curr.node;
            int level = curr.level;
            int vertical = curr.vertical;

            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }

            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(node.val);

            if (node.left != null) {
                queue.offer(new NodeObj(node.left, level + 1, vertical - 1));
            }

            if (node.right != null) {
                queue.offer(new NodeObj(node.right, level + 1, vertical + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, PriorityQueue<Integer>> verticalmap = entry.getValue();
            result.add(new ArrayList<>());
            for (Map.Entry<Integer, PriorityQueue<Integer>> inentry : verticalmap.entrySet()) {
                PriorityQueue<Integer> nodes = inentry.getValue();
                while (!nodes.isEmpty()) {
                    result.get(result.size() - 1).add(nodes.poll());
                }
            }
        }

        return result;
    }
}
