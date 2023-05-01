package neetcode.dp_2d;

import java.util.Arrays;

// https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {
    int[][] dp;

    public int find(String s, String t, int si, int ti) {
        if (ti == 0) {
            return 1;
        }

        if (si == 0) {
            return 0;
        }

        if (dp[si][ti] != -1) {
            return dp[si][ti];
        }

        int count = 0;
        if (s.charAt(si - 1) == t.charAt(ti - 1)) {
            count += find(s, t, si - 1, ti - 1);
        }
        count += find(s, t, si - 1, ti);

        return dp[si][ti] = count;
    }

    public int numDistinct(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return find(s, t, s.length(), t.length());
    }
}
