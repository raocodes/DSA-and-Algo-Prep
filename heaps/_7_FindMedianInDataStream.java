package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class _7_FindMedianInDataStream {
    final Queue<Integer> small; // From small we always want the biggest
    final Queue<Integer> large; // From large we always want the smallest

    public _7_FindMedianInDataStream() {
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);

        if (small.size() - large.size() > 1 || !large.isEmpty() && large.peek() < small.peek()) {
            large.offer(small.poll());
        }

        if (large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else if (small.size() > large.size()) {
            return small.peek();
        } else {
            return large.peek();
        }
    }
}
