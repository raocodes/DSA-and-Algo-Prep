package dp_av._3_longestcommonsubsequence;

// https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1/
public class _7_MinimumNumberDeletionToMakePalindrome {
    int minDeletions(String str, int n) {
        String strrev = new StringBuilder(str).reverse().toString();

        int[][] dp = new int[str.length() + 1][str.length() + 1];

        for (int i = 0; i < str.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < str.length() + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < str.length() + 1; i++) {
            for (int j = 1; j < str.length() + 1; j++) {
                if (str.charAt(i - 1) == strrev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lps = dp[str.length()][str.length()];
        return str.length() - lps;
    }
}
