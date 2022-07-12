package arrays_lcsheet.easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _2_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxprofit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // This finds us the min for the time being
            if (prices[i] < min) {
                // min is the best price to buy at the moment
                min = prices[i];
            }
            // For every element we check against the present min
            if (prices[i] - min > maxprofit) {
                // If the current combo gives us maxprofit then take it
                maxprofit = prices[i] - min;
            }
        }
        return maxprofit;
    }
}
