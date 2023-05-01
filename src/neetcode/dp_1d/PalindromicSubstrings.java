package neetcode.dp_1d;

// Similar to Longest palindromic substring from lc sheet
// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int left, right;

            // Odd
            left = i;
            right = i;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            // Even
            left = i;
            right = i + 1;

            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
