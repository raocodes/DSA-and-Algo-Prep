package striver_sheet.arrays_iii;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
public class _5_GridUniquePath {
    int[][] dp;

    public int findPath(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i == m || j == n) {
            return 0; // This is not a viable route
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int goright = dp[i + 1][j] = findPath(i + 1, j, m, n);
        int godown = dp[i][j + 1] = findPath(i, j + 1, m, n);

        return dp[i][j] = goright + godown;

    }

    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findPath(0, 0, m, n);
    }
}
