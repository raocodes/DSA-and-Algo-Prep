package aditya_verma.dp._3_longestcommonsubsequence;

public class _3_PrintLongestCommonSubsequence {
    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < y + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = x, j = y;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        String finalans = sb.reverse().toString();
        System.out.println(finalans);

        return dp[x][y];
    }
}
