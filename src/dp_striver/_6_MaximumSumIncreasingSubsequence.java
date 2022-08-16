package dp_striver;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
public class _6_MaximumSumIncreasingSubsequence {
    int[][] dp;

    public int findLIS(int index, int prev, int[] arr) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        if (prev == -1 || arr[index] > arr[prev]) {
            // Max between choosing and not choosing
            int chose = dp[index + 1][index + 1] = findLIS(index + 1, index, arr);
            int nochose = dp[index + 1][prev + 1] = findLIS(index + 1, prev, arr);
            return dp[index][prev + 1] = Math.max(arr[index] + chose, nochose);
        } else {
            return dp[index][prev + 1] = findLIS(index + 1, prev, arr);
        }
    }

    public int maxSumIS(int arr[], int n) {
        dp = new int[arr.length + 1][arr.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findLIS(0, -1, arr);
    }
}
