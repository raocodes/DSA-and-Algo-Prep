package dp_av.knapsack;

// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/
public class _3_01Knapsack_tabulation {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        // Initialising with base condition
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
