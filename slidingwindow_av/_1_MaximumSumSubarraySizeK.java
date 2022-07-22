package slidingwindow_av;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class _1_MaximumSumSubarraySizeK {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int start = 0;
        int end = 0;
        long sum = 0;
        long max = Integer.MIN_VALUE;
        while (end < N) {
            sum = sum + Arr.get(end);
            if (end - start + 1 < K) {
                end++;
            } else {
                max = Math.max(max, sum);
                sum -= Arr.get(start);
                end++;
                start++;
            }
        }
        return max;
    }
}
