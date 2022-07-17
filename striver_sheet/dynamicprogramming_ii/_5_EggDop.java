package striver_sheet.dynamicprogramming_ii;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
public class _5_EggDop {
    static int[][] dp = new int[201][201];
    static boolean flag = true;

    static int eggDrop(int n, int k) {
        if (flag) {
            for (int[] arr : dp) {
                Arrays.fill(arr, -1);
            }
            flag = false;
        }

        if (n <= 1) {
            return k;
        }
        if (k <= 1) {
            return k;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        int min = Integer.MAX_VALUE;
        for (int splitpoint = 1; splitpoint <= k; splitpoint++) {
            int broke = dp[n - 1][splitpoint - 1] = eggDrop(n - 1, splitpoint - 1);
            int strong = dp[n][k - splitpoint] = eggDrop(n, k - splitpoint);
            int temp = 1 + Math.max(broke, strong);
            min = Math.min(min, temp);
        }

        return dp[n][k] = min;
    }
}
