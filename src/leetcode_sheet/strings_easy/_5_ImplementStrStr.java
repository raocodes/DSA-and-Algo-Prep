package leetcode_sheet.strings_easy;

// https://leetcode.com/problems/implement-strstr/
public class _5_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int len = needle.length();

        while (i <= haystack.length() - needle.length()) {
            // System.out.println(haystack.substring(i, i + len));
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
