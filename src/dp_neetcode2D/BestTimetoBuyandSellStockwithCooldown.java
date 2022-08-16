package dp_neetcode2D;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimetoBuyandSellStockwithCooldown {
    int[][] dp;

    public int find(int index, boolean tosell, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }

        int temp;
        if (tosell) {
            temp = 1;
        } else {
            temp = 0;
        }

        if (dp[index][temp] != -1) {
            return dp[index][temp];
        }

        if (tosell) {
            return dp[index][temp] = Math.max(find(index + 2, false, prices) + prices[index],
                    find(index + 1, true, prices));
        } else {
            return dp[index][temp] = Math.max(find(index + 1, true, prices) - prices[index],
                    find(index + 1, false, prices));
        }
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return find(0, false, prices);
    }
}
