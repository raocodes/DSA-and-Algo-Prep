package aditya_verma.dp._3_longestcommonsubsequence;

// https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1/
public class _5_MinimumNumberOfDeletionsAndInsertions {
    public int minOperations(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length() + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < str2.length() + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[str1.length()][str2.length()];
        return str1.length() - lcs + str2.length() - lcs;
    }
}
