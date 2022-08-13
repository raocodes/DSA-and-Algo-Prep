package heaps_av_neetcode;

import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1
public class _14_SumOfK1thK2ndSmallestElement {
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        Queue<Long> pq1 = new PriorityQueue<>((o1, o2) -> Long.valueOf(o2).intValue() - Long.valueOf(o1).intValue());
        Queue<Long> pq2 = new PriorityQueue<>((o1, o2) -> Long.valueOf(o2).intValue() - Long.valueOf(o1).intValue());

        for (long num : A) {
            pq1.offer(num);
            pq2.offer(num);

            if (pq1.size() > K1) {
                pq1.poll();
            }

            if (pq2.size() > K2) {
                pq2.poll();
            }
        }

        long first = pq1.peek();
        long second = pq2.peek();

        long sum = 0;
        for (long num : A) {
            if (num > first && num < second) {
                sum += num;
            }
        }

        return sum;
    }
}
