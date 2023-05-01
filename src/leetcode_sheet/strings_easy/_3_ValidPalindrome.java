package leetcode_sheet.strings_easy;

// https://leetcode.com/problems/valid-palindrome-ii/
public class _3_ValidPalindrome {
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // If the remaining part is also a palindrome then that is what is to be deleted
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }
}
