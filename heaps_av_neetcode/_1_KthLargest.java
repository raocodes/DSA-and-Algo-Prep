package heaps_av_neetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class _1_KthLargest {
    final PriorityQueue<Integer> pq;
    final int capacity;

    public _1_KthLargest(int k, int[] nums) {
        capacity = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > capacity) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > capacity) {
            pq.poll();
        }
        return pq.peek();
    }
}
