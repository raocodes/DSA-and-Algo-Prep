package striver_og.dp_i;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/
public class _3_LongestCommonSubsequence {
    int[][] dp;

    public int lcs(String str1, String str2, int index1, int index2) {
        if (index1 == -1 || index2 == -1) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (str1.charAt(index1) == str2.charAt(index2)) {
            return dp[index1][index2] = 1 + lcs(str1, str2, index1 - 1, index2 - 1);
        } else {
            return dp[index1][index2] = Math.max(lcs(str1, str2, index1 - 1, index2),
                    lcs(str1, str2, index1, index2 - 1));
        }

    }

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(text1, text2, text1.length() - 1, text2.length() - 1);
    }
}
