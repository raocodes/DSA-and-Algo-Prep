package dp_neetcode1D;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    int[][] dp;

    public boolean find(int left, int right, String s, List<String> wordDict) {
        if (left > right) {
            return false;
        }

        if (dp[left][right] != -1) {
            return dp[left][right] == 1;
        }

        if (wordDict.contains(s.substring(left, right + 1))) {
            return true;
        }

        for (int k = left; k < right; k++) {
            boolean leftres = find(left, k, s, wordDict);
            dp[left][k] = leftres == true ? 1 : 0;

            boolean rightres = find(k + 1, right, s, wordDict);
            dp[k + 1][right] = rightres == true ? 1 : 0;

            if (rightres && leftres) {
                return true;
            }
        }

        dp[left][right] = 0;
        return false;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return find(0, s.length() - 1, s, wordDict);
    }
}
