package striver_og.dp_ii;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class _4_MinimumCostToCutStick {
    int[][] dp;

    public int findCost(int i, int j, int lstick, int rstick, int[] cuts) {
        if (i == j) {
            // No other cuts available
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // System.out.println(i + " " + j + " " + lstick + " " + rstick);

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = findCost(i, k, lstick, cuts[k], cuts);
            int right = findCost(k + 1, j, cuts[k], rstick, cuts);
            int total = (rstick - lstick) + left + right;
            // System.out.println("total" + total);

            ans = Math.min(ans, total);
        }

        return dp[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        dp = new int[cuts.length + 1][cuts.length + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findCost(0, cuts.length, 0, n, cuts);
    }
}
