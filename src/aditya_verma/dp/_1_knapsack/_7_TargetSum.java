package aditya_verma.dp._1_knapsack;

// https://leetcode.com/problems/target-sum/
public class _7_TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int element : nums) {
            total += element;
        }

        if (Math.abs(target) > total)
            return 0;

        if ((target + total) % 2 != 0)
            return 0;

        int sum = (target + total) / 2;

        int[][] dp = new int[nums.length + 1][sum + 1];

        for (int i = 1; i < sum + 1; i++) {
            // if size of remaining values is 0
            dp[0][i] = 0;
        }
        dp[0][0] = 1; // // If remaining sum is 0 and size of remaining values is 0

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - nums[i - 1]] + dp[i - 1][j]);
                } else {
                    dp[i][j] = (dp[i - 1][j]);
                }
            }
        }

        return dp[nums.length][sum];
    }
}
