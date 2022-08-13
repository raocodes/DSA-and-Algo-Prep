package dp_av._3_longestcommonsubsequence;

// https://leetcode.com/problems/is-subsequence/
public class _10_SequencePatternMatching {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < t.length() + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // If the longest common subsequence between s and t is the length of s.
        // s is definitely a subsequence of t
        if (dp[s.length()][t.length()] == s.length())
            return true;
        else
            return false;
    }
}
