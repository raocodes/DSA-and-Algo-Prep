package leetcode_sheet.strings_medium;

// https://leetcode.com/problems/longest-palindromic-substring/
public class _3_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int resultlen = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            int left, right;

            // Odd
            left = i;
            right = i;

            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultlen) {
                    result = s.substring(left, right + 1);
                    resultlen = right - left + 1;
                }
                left--;
                right++;
            }

            // Even
            left = i;
            right = i + 1;

            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resultlen) {
                    result = s.substring(left, right + 1);
                    resultlen = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return result;
    }
}
