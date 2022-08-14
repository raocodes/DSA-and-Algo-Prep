package arrays_lc.easy;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class _5_BestTimeToBuySellStockMEDIUM {
    int[][] dp;

    public int find(int index, int buy, int[] prices) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        if (buy == 1) {
            // We have to purchase
            return dp[index][buy] = Math.max(find(index + 1, 0, prices) - prices[index],
                    find(index + 1, 1, prices));
        } else {
            // We have to sell
            return dp[index][buy] = Math.max(find(index + 1, 1, prices) + prices[index],
                    find(index + 1, 0, prices));
        }
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];

        dp[prices.length][1] = 0;
        dp[prices.length][0] = 0;

        for (int i = prices.length - 1; i >= 0; i--)


            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

        // Buy = 1
        // Sell = 0
        return find(0, 1, prices);
    }

    public int maxProfitTabulation(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        dp[prices.length][1] = 0;
        dp[prices.length][0] = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    dp[i][j] = Math.max(dp[i + 1][0] - prices[i], dp[i + 1][1]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][1] + prices[i], dp[i + 1][0]);
                }
            }
        }

        return dp[0][1];
    }
}
