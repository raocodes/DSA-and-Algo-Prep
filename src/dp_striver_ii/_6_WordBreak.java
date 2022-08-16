package dp_striver_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/word-break1352/1
public class _6_WordBreak {
    static int[][] dp;

    public static int findSegment(int i, int j, String A, HashSet<String> dictionary) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (dictionary.contains(A.substring(i, j + 1))) {
            return dp[i][j] = 1;
        }

        int ans = 0;
        for (int k = i; k < j; k++) {
            int left = dp[i][k] = findSegment(i, k, A, dictionary);
            int right = dp[k + 1][j] = findSegment(k + 1, j, A, dictionary);

            if ((left & right) == 1) {
                ans = ans | 1;
            }
        }

        return dp[i][j] = ans;
    }

    public static int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dictionary = new HashSet<>(B);
        dp = new int[A.length()][A.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findSegment(0, A.length() - 1, A, dictionary);
    }
}
