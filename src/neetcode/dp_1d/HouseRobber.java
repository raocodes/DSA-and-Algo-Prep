package neetcode.dp_1d;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    int[] dp;

    public int solve(int index, int[] nums) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // Rob the house
        int rob = nums[index] + solve(index + 2, nums);
        int skip = solve(index + 1, nums);

        return dp[index] = Math.max(rob, skip);
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums);
    }
}
