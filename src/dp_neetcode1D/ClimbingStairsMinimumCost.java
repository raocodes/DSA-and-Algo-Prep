package dp_neetcode1D;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class ClimbingStairsMinimumCost {
    int[] dp;

    public int find(int index, int[] cost) {
        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int onestep = cost[index] + find(index + 1, cost);
        int twostep = cost[index] + find(index + 2, cost);

        return dp[index] = Math.min(onestep, twostep);
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(find(0, cost), find(1, cost));
    }
}
