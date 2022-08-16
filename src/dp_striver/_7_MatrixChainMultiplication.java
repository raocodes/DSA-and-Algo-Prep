package dp_striver;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class _7_MatrixChainMultiplication {
    static int[][] dp;

    static int findEfficient(int i, int j, int[] arr) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = findEfficient(i, k, arr) + findEfficient(k + 1, j, arr) + (arr[i - 1] * arr[k]
                    * arr[j]);

            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }

    static int matrixMultiplication(int N, int arr[]) {
        dp = new int[arr.length][arr.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findEfficient(1, arr.length - 1, arr);
    }
}
