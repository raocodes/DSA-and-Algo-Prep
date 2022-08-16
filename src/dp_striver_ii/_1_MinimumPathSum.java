package dp_striver_ii;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-path-sum/
public class _1_MinimumPathSum {
    int[][] dp;

    public int findPath(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (i >= grid.length || j >= grid[0].length) {
            return 1000000000;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = grid[i][j] + findPath(i + 1, j, grid);
        int right = grid[i][j] + findPath(i, j + 1, grid);

        return dp[i][j] = Math.min(down, right);
    }

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length + 1][grid[0].length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findPath(0, 0, grid);
    }
}
