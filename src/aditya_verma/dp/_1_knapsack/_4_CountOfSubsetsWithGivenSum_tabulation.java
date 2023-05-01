package aditya_verma.dp._1_knapsack;

// https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#
public class _4_CountOfSubsetsWithGivenSum_tabulation {
    public int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 1; i < sum + 1; i++) {
            // if size of remaining values is 0
            dp[0][i] = 0;
        }
        dp[0][0] = 1; // // If remaining sum is 0 and size of remaining values is 0

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]) % 1000000007;
                } else {
                    dp[i][j] = (dp[i - 1][j]) % 1000000007;
                }
            }
        }

        return dp[n][sum];
    }
}
