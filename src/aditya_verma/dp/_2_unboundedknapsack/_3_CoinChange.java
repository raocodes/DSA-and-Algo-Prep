package aditya_verma.dp._2_unboundedknapsack;

// https://practice.geeksforgeeks.org/problems/coin-change2448/1
public class _3_CoinChange {
    public long count(int S[], int m, int n) {
        long[][] dp = new long[m + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            // if size of remaining values is 0
            dp[0][i] = 0;
        }
        dp[0][0] = 1; // // If remaining sum is 0 and size of remaining values is 0

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (S[i - 1] <= j) {
                    dp[i][j] = (dp[i][j - S[i - 1]] + dp[i - 1][j]);
                } else {
                    dp[i][j] = (dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
