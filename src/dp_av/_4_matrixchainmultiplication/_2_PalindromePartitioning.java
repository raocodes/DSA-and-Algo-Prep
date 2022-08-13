package dp_av._4_matrixchainmultiplication;

// https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/#
public class _2_PalindromePartitioning {
    static int[][] dp;

    static boolean findPalindrome(String str) {
        int j = str.length() - 1;
        int i = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int findMin(String str, int i, int j) {
        if (i >= j) {
            // If there is only one element left then this substring is a palindrome
            // Single character string is a palindrome
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (findPalindrome(str.substring(i, j + 1)))
            return dp[i][j] = 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = findMin(str, i, k);
            dp[i][k] = left;

            int right = findMin(str, k + 1, j);
            dp[k + 1][j] = right;

            int temp = 1 + left + right;
            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }

    static int palindromicPartition(String str) {
        dp = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return findMin(str, 0, str.length() - 1);
    }
}
