package striver_sheet.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class _2_LongestIncreasingSubsequence {
    int dp[][];

    public int findLIS(int index, int prev, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        if (prev == -1 || nums[index] > nums[prev]) {
            // Max between choosing and not choosing
            int chose = dp[index + 1][index + 1] = findLIS(index + 1, index, nums);
            int nochose = dp[index + 1][prev + 1] = findLIS(index + 1, prev, nums);
            return dp[index][prev + 1] = Math.max(1 + chose, nochose);
        } else {
            return dp[index][prev + 1] = findLIS(index + 1, prev, nums);
        }
    }

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1][nums.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findLIS(0, -1, nums);
    }
}
