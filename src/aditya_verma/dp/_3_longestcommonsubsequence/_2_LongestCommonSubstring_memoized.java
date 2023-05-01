package aditya_verma.dp._3_longestcommonsubsequence;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
public class _2_LongestCommonSubstring_memoized {
    int[][] dp;

    int lcs(int x, int y, String s1, String s2, int[] max) {
        if (x == 0 || y == 0) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        lcs(x - 1, y, s1, s2, max);
        lcs(x, y - 1, s1, s2, max);

        if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
            int result = 1 + lcs(x - 1, y - 1, s1, s2, max);
            max[0] = Math.max(max[0], result);
            return dp[x][y] = result;
        } else {
            return dp[x][y] = 0;
        }
    }

    int longestCommonSubstr(String S1, String S2, int n, int m) {
        dp = new int[S1.length() + 1][S2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int[] max = new int[] { 0 };
        lcs(S1.length(), S2.length(), S1, S2, max);
        return max[0];
    }
}
