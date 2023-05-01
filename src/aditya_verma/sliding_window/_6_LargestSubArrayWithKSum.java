package aditya_verma.sliding_window;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
public class _6_LargestSubArrayWithKSum {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int max = 0;
        int sum = 0;

        Map<Integer, Integer> prefixsum = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sum += A[i];

            if (sum == K) {
                max = Math.max(max, i + 1);
            }

            if (prefixsum.containsKey(sum - K)) {
                max = Math.max(max, i - prefixsum.get(sum - K));
            }

            if (!prefixsum.containsKey(sum)) {
                prefixsum.put(sum, i);
            }
        }

        return max;
    }
}
