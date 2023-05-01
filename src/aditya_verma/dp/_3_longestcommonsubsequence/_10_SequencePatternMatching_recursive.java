package aditya_verma.dp._3_longestcommonsubsequence;

// https://leetcode.com/problems/is-subsequence/
public class _10_SequencePatternMatching_recursive {
    public boolean findIfSub(int is, int it, String s, String t) {
        if (is == s.length()) {
            // We have reached the end of subsequence string
            // Therefore it is surely a subsequence
            return true;
        }

        if (it == t.length()) {
            // We have reached the end of parent string
            // We have not reached the end of subsequence string
            // Therefore it is surely not a subsequence
            return false;
        }

        if (s.charAt(is) == t.charAt(it)) {
            // If equal go to next in both strings
            return findIfSub(is + 1, it + 1, s, t);
        } else {
            // If unequal go to next only in parent string
            return findIfSub(is, it + 1, s, t);
        }
    }

    public boolean isSubsequence(String s, String t) {
        return findIfSub(0, 0, s, t);
    }
}
