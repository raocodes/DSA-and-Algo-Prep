package aditya_verma.dp._1_knapsack;

public class _6_CountofSubsetsWithGivenDifference {
    public int perfectSum(int arr[], int n, int diff) {
        // Basically Count of subsets with given sum but with this small change
        int total = 0;
        for (int element : arr) {
            total += element;
        }

        int sum = (diff + total) / 2;

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
