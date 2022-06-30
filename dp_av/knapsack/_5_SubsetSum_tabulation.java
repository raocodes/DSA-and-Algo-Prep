package dp_av.knapsack;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/
public class _5_SubsetSum_tabulation {
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];

        for (int i = 0; i < N + 1; i++) {
            // If remaining sum is 0
            dp[i][0] = true;
        }

        for (int i = 1; i < sum + 1; i++) {
            // if size of remaining values is 0
            dp[0][i] = false;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }
}
