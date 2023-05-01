package aditya_verma.dp._2_unboundedknapsack;

// https://practice.geeksforgeeks.org/problems/number-of-coins1824/1/#
public class _4_CoinChangeII {
    public int minCoins(int coins[], int M, int V) {
        int[][] dp = new int[M + 1][V + 1];

        for (int i = 0; i < M + 1; i++) {
            // For sum 0, no coins are needed
            dp[i][0] = 0;
        }
        for (int i = 1; i < V + 1; i++) {
            // For sum > 0, 0 coins remaining means that it can never happen so infinity
            dp[0][i] = Integer.MAX_VALUE - 1;
            // max - 1 because otherwise at + 1 we will get overflow
        }

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (coins[i - 1] <= j) {
                    // We change to finding the min number
                    dp[i][j] = Math.min(
                            // One coin count is added when it is chosen
                            1 + dp[i][j - coins[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[M][V] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return dp[M][V];
    }
}
