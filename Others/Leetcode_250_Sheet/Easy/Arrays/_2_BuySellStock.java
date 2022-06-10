package Others.Leetcode_250_Sheet.Easy.Arrays;

public class _2_BuySellStock {
    public int maxProfit(int[] prices) {
        int minprice = 100000, maxprice = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            }
            if (price - minprice > maxprice) {
                maxprice = price - minprice;
            }
        }
        return maxprice;
    }
}
