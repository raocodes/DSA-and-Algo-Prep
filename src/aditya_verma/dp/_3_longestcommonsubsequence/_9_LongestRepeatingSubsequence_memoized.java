package aditya_verma.dp._3_longestcommonsubsequence;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
public class _9_LongestRepeatingSubsequence_memoized {
    int[][] dp;

    public int find(int s1idx, int s2idx, String str) {
        if (s1idx == 0 || s2idx == 0) {
            return 0;
        }

        if (dp[s1idx][s2idx] != -1) {
            return dp[s1idx][s2idx];
        }

        if (str.charAt(s1idx - 1) == str.charAt(s2idx - 1) && (s1idx - 1) != (s2idx - 1)) {
            return dp[s1idx][s2idx] = 1 + find(s1idx - 1, s2idx - 1, str);
        } else {
            return dp[s1idx][s2idx] = Math.max(find(s1idx - 1, s2idx, str), find(s1idx, s2idx - 1, str));
        }
    }

    public int LongestRepeatingSubsequence(String str) {
        dp = new int[str.length() + 1][str.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return find(str.length(), str.length(), str);
    }
}
