package neetcode.dp_2d;

import java.util.Arrays;

// https://leetcode.com/problems/burst-balloons/
public class BurstBalloons {
    int[][] dp;

    public int find(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int left, right;

            if (i - 1 == -1) {
                left = 1;
            } else {
                left = nums[i - 1];
            }

            if (j + 1 == nums.length) {
                right = 1;
            } else {
                right = nums[j + 1];
            }

            // Dividing range into i - 1, find(i, k - 1), k, find(i + 1, j), j + 1
            int current = left * nums[k] * right;
            // We are basically first fully popping the left and right subgroup
            // After popping the left and right subgroup we are then popping the main thing
            int leftsubgroup = find(nums, i, k - 1);
            int rightsubgroup = find(nums, k + 1, j);

            int result = current + leftsubgroup + rightsubgroup;
            ans = Math.max(ans, result);
        }

        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = find(nums, 0, nums.length - 1);
        return result;
    }
}
