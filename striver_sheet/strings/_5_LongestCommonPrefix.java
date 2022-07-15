package striver_sheet.strings;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/
public class _5_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String comp1 = strs[0];
        String comp2 = strs[strs.length - 1];

        int length = 0;
        int i = 0;
        int maxlength = Math.min(comp1.length(), comp2.length());

        while (i < maxlength && comp1.charAt(i) == comp2.charAt(i)) {
            length++;
            i++;
        }

        return comp1.substring(0, length);
    }
}
