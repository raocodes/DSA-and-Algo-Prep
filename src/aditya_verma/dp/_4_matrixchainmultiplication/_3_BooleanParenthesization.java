package aditya_verma.dp._4_matrixchainmultiplication;

// https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1/#
public class _3_BooleanParenthesization {
    static int findWays(String str, int i, int j, boolean what) {
        if (i > j) {
            return 0;
            // No evaluation possible
        }
        if (i == j) {
            if (what) {
                if (str.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (str.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        int sum = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            int lefttrue = findWays(str, i, k - 1, true);
            int leftfalse = findWays(str, i, k - 1, false);
            int righttrue = findWays(str, k + 1, j, true);
            int rightfalse = findWays(str, k + 1, j, false);

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

        return sum;
    }

    static int countWays(int N, String S) {
        return findWays(S, 0, S.length() - 1, true);
    }
}
