package striver_og.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class _25_AllNodesKDistance {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.add(root);
        map.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }

        int distance = 0;
        queue.add(target);
        while (!queue.isEmpty() && distance < k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                if (map.get(node) != null) {
                    if (!visited.contains(map.get(node))) {
                        queue.add(map.get(node));
                    }
                }
                if (node.left != null) {
                    if (!visited.contains(node.left)) {
                        queue.add(node.left);
                    }
                }
                if (node.right != null) {
                    if (!visited.contains(node.right)) {
                        queue.add(node.right);
                    }
                }
            }
            distance++;
        }

        List<Integer> result = new ArrayList<>();

        if (distance != k) {
            return result;
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }
}
