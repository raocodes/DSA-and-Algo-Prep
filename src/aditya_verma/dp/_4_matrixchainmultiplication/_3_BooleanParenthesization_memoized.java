package aditya_verma.dp._4_matrixchainmultiplication;

// https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1/#
public class _3_BooleanParenthesization_memoized {
    static int[][][] dp;

    static int findWays(String str, int i, int j, boolean what) {
        if (i > j) {
            return 0;
            // No evaluation possible
        }

        int flag;
        if (what) {
            flag = 1;
        } else {
            flag = 0;
        }

        if (dp[i][j][flag] != -1) {
            return dp[i][j][flag];
        }

        if (i == j) {
            if (what) {
                if (str.charAt(i) == 'T') {
                    return dp[i][j][flag] = 1;
                } else {
                    return dp[i][j][flag] = 0;
                }
            } else {
                if (str.charAt(i) == 'F') {
                    return dp[i][j][flag] = 1;
                } else {
                    return dp[i][j][flag] = 0;
                }
            }
        }

        int sum = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lefttrue = findWays(str, i, k - 1, true);
            dp[i][k - 1][1] = lefttrue % 1003;

            int leftfalse = findWays(str, i, k - 1, false);
            dp[i][k - 1][0] = leftfalse % 1003;

            int righttrue = findWays(str, k + 1, j, true);
            dp[k + 1][j][1] = righttrue % 1003;

            int rightfalse = findWays(str, k + 1, j, false);
            dp[k + 1][j][0] = rightfalse % 1003;

            if (str.charAt(k) == '|') {
                // OR
                if (what) {
                    sum += lefttrue * righttrue + lefttrue * rightfalse + leftfalse * righttrue;
                } else {
                    sum += leftfalse * rightfalse;
                }

            } else if (str.charAt(k) == '&') {
                // AND
                if (what) {
                    sum += lefttrue * righttrue;
                } else {
                    sum += lefttrue * rightfalse + leftfalse * righttrue + leftfalse * rightfalse;
                }

            } else if (str.charAt(k) == '^') {
                // XOR
                if (what) {
                    sum += lefttrue * rightfalse + leftfalse * righttrue;
                } else {
                    sum += lefttrue * righttrue + leftfalse * rightfalse;
                }
            }
        }

        return dp[i][j][flag] = sum % 1003;
    }

    static int countWays(int N, String S) {
        dp = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return findWays(S, 0, S.length() - 1, true);
    }
}
