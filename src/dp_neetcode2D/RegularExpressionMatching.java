package dp_neetcode2D;

import java.util.Arrays;

// https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
    int[][] dp;

    private int find(String s, String p, int si, int pi) {
        if (si < 0 && pi < 0) {
            // Both strings are over
            return 1;
        }

        if (si < 0 && pi >= 0) {
            // String is over but pattern is remaining
            while (pi >= 0) {
                if (p.charAt(pi) == '*') {
                    pi -= 2;
                } else {
                    return 0;
                }
            }
            return 1;
        }

        if (si >= 0 && pi < 0) {
            // String is remaining but pattern is over
            return 0;
        }

        if (dp[si][pi] != -1) {
            return dp[si][pi];
        }

        if (p.charAt(pi) == '*') {
            // If a * is there, there are 2 posibilites
            // It can match it and it can not match it
            // p - 1 always exists in this case
            if (s.charAt(si) == p.charAt(pi - 1) || p.charAt(pi - 1) == '.') {
                int matchingonce = find(s, p, si - 1, pi);
                int ignoring = find(s, p, si, pi - 2);
                return dp[si][pi] = matchingonce | ignoring;
            } else {
                // If it does not match with the previous character just ignore
                return dp[si][pi] = find(s, p, si, pi - 2);
            }
        } else if (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.') {
            return dp[si][pi] = find(s, p, si - 1, pi - 1);
        }

        return dp[si][pi] = 0;
    }

    public boolean isMatch(String s, String p) {
        dp = new int[s.length()][p.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = find(s, p, s.length() - 1, p.length() - 1);
        return result == 0 ? false : true;
    }
}
