package dp_striver_ii;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
public class _7_PalindromicPartitioning {
    static int[][] dp;

    static boolean isPalindrome(String str) {
        StringBuilder strtemp = new StringBuilder(str);
        return strtemp.reverse().toString().equals(str);
    }

    static int findPartitions(int i, int j, String str) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (isPalindrome(str.substring(i, j + 1))) {
            return dp[i][j] = 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int leftpartition = findPartitions(i, k, str);
            int rightpartition = findPartitions(k + 1, j, str);
            int total = 1 + leftpartition + rightpartition;

            ans = Math.min(ans, total);
        }

        return dp[i][j] = ans;
    }

    static int palindromicPartition(String str) {
        dp = new int[str.length()][str.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findPartitions(0, str.length() - 1, str);
    }
}
