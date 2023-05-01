package striver_og.dp_i;

import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/
public class _5_EditDistance {
    int[][] dp;

    public int calculate(String str1, String str2, int index1, int index2) {
        if (index1 == 0) {
            // Remaining insertions from str2
            return index2;
        }

        if (index2 == 0) {
            // Remaining insertions from str1
            return index1;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
            return dp[index1][index2] = 0 + calculate(str1, str2, index1 - 1, index2 - 1);
        } else {
            int insert = 1 + calculate(str1, str2, index1, index2 - 1);
            int delete = 1 + calculate(str1, str2, index1 - 1, index2);
            int replace = 1 + calculate(str1, str2, index1 - 1, index2 - 1);
            int temp = Math.min(insert, delete);
            return dp[index1][index2] = Math.min(temp, replace);
        }
    }

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int calculate = calculate(word1, word2, word1.length(), word2.length());
        return calculate;
    }
}
