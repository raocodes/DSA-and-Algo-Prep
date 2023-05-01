package striver_og.dp_i;

import java.util.Arrays;

// https://leetcode.com/problems/ones-and-zeroes/
public class _4_OnesAndZeroes {
    int[][][] dp;

    public int largestSubset(int index, String[] strs, int m, int n) {
        if (index == -1 || (m == 0 && n == 0)) {
            return 0;
        }

        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        int onecount = 0;
        int zerocount = 0;

        for (char ch : strs[index].toCharArray()) {
            if (ch == '1') {
                onecount++;
            } else if (ch == '0') {
                zerocount++;
            }
        }

        if (zerocount <= m && onecount <= n) {
            return dp[index][m][n] = Math.max(1 + largestSubset(index - 1, strs, m - zerocount, n - onecount),
                    largestSubset(index - 1, strs, m, n));
        } else {
            return dp[index][m][n] = largestSubset(index - 1, strs, m, n);
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m + 1][n + 1];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return largestSubset(strs.length - 1, strs, m, n);
    }
}
