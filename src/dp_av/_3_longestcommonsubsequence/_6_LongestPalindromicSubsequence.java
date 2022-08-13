package dp_av._3_longestcommonsubsequence;

// https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1/
public class _6_LongestPalindromicSubsequence {
    public int longestPalinSubseq(String S) {
        String Srev = new StringBuilder(S).reverse().toString();

        int[][] dp = new int[S.length() + 1][S.length() + 1];

        for (int i = 0; i < S.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < S.length() + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < S.length() + 1; j++) {
                if (S.charAt(i - 1) == Srev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[S.length()][S.length()];
    }
}
