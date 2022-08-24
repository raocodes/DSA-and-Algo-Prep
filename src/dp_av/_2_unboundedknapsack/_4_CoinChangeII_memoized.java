package dp_av._2_unboundedknapsack;

import java.util.Arrays;

public class _4_CoinChangeII_memoized {
    int[][] dp;

    public int find(int[] coins, int target, int index) {
        if (target == 0) {
            return 0;
        }

        if (index < 0) {
            return 100000000;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        if (coins[index] <= target) {
            return dp[index][target] = Math.min(1 + find(coins, target - coins[index], index),
                    find(coins, target, index - 1));
        } else {
            return dp[index][target] = find(coins, target, index - 1);
        }
    }

    public int minCoins(int coins[], int M, int V) {
        dp = new int[coins.length][V + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(coins);
        int result = find(coins, V, M - 1);
        if (result >= 100000000) {
            return -1;
        }
        return result;
    }
}
