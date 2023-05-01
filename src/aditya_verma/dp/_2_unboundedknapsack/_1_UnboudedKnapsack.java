package aditya_verma.dp._2_unboundedknapsack;

// https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1/
public class _1_UnboudedKnapsack {
    static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N + 1][W + 1];
        // Initialising with base condition
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i][j - wt[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }
}
