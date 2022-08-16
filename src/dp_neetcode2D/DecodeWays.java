package dp_neetcode2D;

import java.util.Arrays;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    int[] dp;

    private int find(int index, String s) {
        if (index == s.length()) {
            // Reached the end
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int result = find(index + 1, s);
        // If it starts with 1 it can be anything afer
        // If it starts with 2 it cannot be anything after
        if (index < s.length() - 1
                && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {
            result += find(index + 2, s);
        }

        return dp[index] = result;
    }

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return find(0, s);
    }
}
