package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
public class _13_MinimumCostOfRopes {
    long minCost(long arr[], int n) {
        Queue<Long> pq = new PriorityQueue<>();

        for (long num : arr) {
            pq.offer(num);
        }

        long totalcost = 0;
        while (pq.size() != 1) {
            long first = pq.poll();
            long second = pq.poll();
            long sum = first + second;
            totalcost += sum;
            pq.offer(sum);
        }

        return totalcost;
    }
}
