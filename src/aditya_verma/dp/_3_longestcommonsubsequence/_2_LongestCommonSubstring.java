package aditya_verma.dp._3_longestcommonsubsequence;

// https://www.interviewbit.com/blog/longest-common-substring/ - Diagram explanation
// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1/

public class _2_LongestCommonSubstring {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        int max = 0; // We need this variable as substring can be anywhere
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j], max);
                } else {
                    // If they are not the same then we break the longest value
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
}
