package dp_av._3_longestcommonsubsequence;

public class _8_PrintShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
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

        int i = str1.length(), j = str2.length();
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    // Here we are moving through str2 as we are reducing j
                    // Therefore we include str2[j-1]
                    sb.append(str2.charAt(j - 1));
                    j--;
                } else {
                    // Here we are moving through str1 as we are reducing i
                    // Therefore we include str1[i-1]
                    sb.append(str1.charAt(i - 1));
                    i--;
                }
            }
        }

        // We have finished str1 but we need to add whatever is left in str2
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // We have finished str2 but we need to add whatever is left in str1
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        String finalans = sb.reverse().toString();
        return finalans;
    }
}
