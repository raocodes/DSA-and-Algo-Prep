package dp_av._3_longestcommonsubsequence;

// https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
public class _1_LongestCommonSubsequence_memoized {
    static int[][] dp;

    static int findnextlcs(int x, int y, String s1, String s2) {
        if (x == 0 || y == 0) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
            return dp[x][y] = 1 + lcs(x - 1, y - 1, s1, s2);
        } else {
            return dp[x][y] = Math.max(
                    lcs(x - 1, y, s1, s2),
                    lcs(x, y - 1, s1, s2));
        }
    }

    static int lcs(int x, int y, String s1, String s2) {
        dp = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return findnextlcs(x, y, s1, s2);
    }
}
