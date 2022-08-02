package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/last-stone-weight/
public class _2_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                pq.offer(y - x);
            }
        }

        if (pq.size() == 0) {
            return 0;
        } else {
            return pq.peek();
        }
    }
}
