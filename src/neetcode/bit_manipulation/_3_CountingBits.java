package neetcode.bit_manipulation;

// https://leetcode.com/problems/counting-bits/
public class _3_CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int offset = 1;

        for (int i = 1; i < n + 1; i++) {
            // 0 - 0000
            // 1 - 0001
            // 2 - 0010 (1 + dp[0])
            // 3 - 0011 (1 + dp[1])
            // 4 - 0100 (1 + dp[0])
            // 5 - 0101 (1 + dp[1])
            // 6 - 0110 (1 + dp[2])
            // 7 - 0111 (1 + dp[3])
            // 8 - 1000
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }
}
