package striver_sheet.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class _5_PalindromePartitioning {
    public void findPartition(int index, String s, List<String> partitions, List<List<String>> result) {
        if (index == s.length()) {
            // Reached the end
            result.add(new ArrayList<>(partitions));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            // end = index because we also consider single characters as a possible
            // substring
            if (isPalindrome(s.substring(index, end + 1))) {
                partitions.add(s.substring(index, end + 1));
                findPartition(end + 1, s, partitions, result);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String tocheck) {
        int start = 0;
        int end = tocheck.length() - 1;
        while (start < end) {
            if (tocheck.charAt(start) != tocheck.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<String> partitions = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        findPartition(0, s, partitions, result);
        return result;
    }
}
