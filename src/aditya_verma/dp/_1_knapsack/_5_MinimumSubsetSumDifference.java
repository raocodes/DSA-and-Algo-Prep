package aditya_verma.dp._1_knapsack;

// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/#
public class _5_MinimumSubsetSumDifference {
    public int minDifference(int arr[], int n) {
        int range = 0;
        for (int element : arr) {
            range += element;
        }

        boolean[][] dp = new boolean[n + 1][range + 1];

        for (int i = 0; i < n + 1; i++) {
            // If remaining sum is 0
            dp[i][0] = true;
        }

        for (int i = 1; i < range + 1; i++) {
            // if size of remaining values is 0
            dp[0][i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        boolean[] possibleSubsetSums = dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= range / 2; i++) {
            if (possibleSubsetSums[i]) {
                min = Math.min(min, range - 2 * i);
            }
        }

        return min;
    }
}
