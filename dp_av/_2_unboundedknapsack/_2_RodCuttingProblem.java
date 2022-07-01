package dp_av._2_unboundedknapsack;

// https://practice.geeksforgeeks.org/problems/rod-cutting0840/1/
public class _2_RodCuttingProblem {
    public int cutRod(int price[], int n) {
        // We generate the length array (similar to weight array in knapsack)
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            // Contains values from 1 - n
            length[i] = i + 1;
        }

        int[][] dp = new int[n + 1][n + 1];
        // Initialising with base condition
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            price[i - 1] + dp[i][j - length[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}
