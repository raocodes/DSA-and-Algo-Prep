import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/distinct-palindromic-substrings5141/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// Similar to Longest palindromic substring from lc sheet
// https://leetcode.com/problems/palindromic-substrings/
public class DistincPalindromeSubstrings {
    int palindromeSubStrs(String str) {
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int left, right;

            // Odd
            left = i;
            right = i;
            while (left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
                hash.add(str.substring(left, right + 1));
                left--;
                right++;
            }

            // Even
            left = i;
            right = i + 1;

            while (left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
                hash.add(str.substring(left, right + 1));
                left--;
                right++;
            }
        }

        return hash.size();
    }
}
