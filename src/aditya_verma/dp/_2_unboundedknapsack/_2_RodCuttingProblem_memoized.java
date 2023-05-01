package aditya_verma.dp._2_unboundedknapsack;

import java.util.Arrays;

public class _2_RodCuttingProblem_memoized {
    int[][] dp;

    public int find(int[] price, int index, int length) {
        if (length == 0 || index == 0) {
            return 0;
        }

        if (dp[index][length] != -1) {
            return dp[index][length];
        }

        if (index <= length) {
            return dp[index][length] = Math.max(price[index - 1] + find(price, index, length - index),
                    find(price, index - 1, length));
        } else {
            return dp[index][length] = find(price, index - 1, length);
        }
    }

    public int cutRod(int price[], int n) {
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return find(price, n, n);
    }
}
