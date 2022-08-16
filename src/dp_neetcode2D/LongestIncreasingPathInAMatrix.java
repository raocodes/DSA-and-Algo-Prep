package dp_neetcode2D;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/
public class LongestIncreasingPathInAMatrix {
    int[][] dp;

    public int dfs(int[][] matrix, int i, int j, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = dfs(matrix, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, i, j + 1, matrix[i][j]);
        int down = dfs(matrix, i + 1, j, matrix[i][j]);
        int up = dfs(matrix, i - 1, j, matrix[i][j]);

        int sides = Math.max(left, right);
        int updown = Math.max(up, down);

        return dp[i][j] = 1 + Math.max(sides, updown);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        dp = new int[matrix.length][matrix[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] == -1) {
                    result = Math.max(result, dfs(matrix, i, j, -1));
                }
            }
        }

        return result;
    }
}
