package striver_og.dp_i;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
public class _6_MaximumSumIncreasingSubsequence {
    int[][] dp;

    public int find(int[] arr, int index, int prev, int n) {
        if (index == n) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        if (prev == -1 || arr[index] > arr[prev]) {
            return dp[index][prev + 1] = Math.max(arr[index] + find(arr, index + 1, index, n),
                    find(arr, index + 1, prev, n));
        } else {
            return dp[index][prev + 1] = find(arr, index + 1, prev, n);
        }
    }

    public int maxSumIS(int arr[], int n) {
        dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return find(arr, 0, -1, n);
    }
}
