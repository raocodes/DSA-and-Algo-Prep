package companyot.aster;

import java.util.Arrays;

public class Levenshtein {
    static int[][] dp;

    static int minDis(String s1, String s2, int n, int m) {
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = minDis(s1, s2, n - 1, m - 1);
        } else {
            int insert = minDis(s1, s2, n, m - 1);
            int del = minDis(s1, s2, n - 1, m);
            int replace = minDis(s1, s2, n - 1, m - 1);
            return dp[n][m] = 1 + Math.min(insert, Math.min(del, replace));
        }
    }

    static String solve(int N, String[] words, String s) {
        String result = s;
        int result_count = Integer.MAX_VALUE;

        for (String word : words) {
            int n = word.length();
            int m = s.length();

            dp = new int[n + 1][m + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int res = minDis(word, s, n, m);
            if (res == result_count) {
                result = result.compareTo(word) <= 0 ? result : word;
            } else if (res < result_count) {
                result = word;
                result_count = res;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        String[] words = new String[] { "tocor", "torect", "tocfrrec", "tocorre", "tocofecd" };

        System.out.println(solve(N, words, "tocorrect"));
    }
}
