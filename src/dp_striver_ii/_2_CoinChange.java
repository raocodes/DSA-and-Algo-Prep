package dp_striver_ii;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class _2_CoinChange {
    int[][] dp;

    public int findCoin(int index, int[] coins, int amount) {
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        if (amount == 0) {
            return 0;
        }

        if (index == 0) {
            return 1000000000;
        }

        if (coins[index - 1] <= amount) {
            return dp[index][amount] = Math.min(1 + findCoin(index, coins, amount - coins[index - 1]),
                    findCoin(index - 1, coins, amount));
        } else {
            return dp[index][amount] = findCoin(index - 1, coins, amount);
        }
    }

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int toreturn = findCoin(coins.length, coins, amount);
        if (toreturn == 1000000000) {
            return -1;
        }
        return toreturn;
    }
}
