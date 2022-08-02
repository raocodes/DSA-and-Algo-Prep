package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class _3_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Double[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return 0;
            }
        });

        for (int[] point : points) {
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            pq.offer(new Double[] { distance, Double.valueOf(point[0]), Double.valueOf(point[1]) });
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Double[] temp = pq.poll();
            result[i] = new int[] { temp[1].intValue(), temp[2].intValue() };
        }

        return result;
    }
}
