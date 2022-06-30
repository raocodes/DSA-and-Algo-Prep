package dp_av.knapsack;

// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
public class _7_EqualPartition_tabulation {
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }

        if (sum % 2 != 0) {
            // 2 equal partitions are not possible if sum cannot be divided
            return 0;
        }

        sum = sum / 2;

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

        if (dp[N][sum])
            return 1;
        else
            return 0;
    }
}
