package dp_av._3_longestcommonsubsequence;

// https://leetcode.com/problems/is-subsequence/
public class _10_SequencePatternMatching_twopointer {
    public boolean isSubsequence(String s, String t) {
        int lefts = 0;
        int leftt = 0;

        while (lefts < s.length() && leftt < t.length()) {
            if (s.charAt(lefts) == t.charAt(leftt)) {
                lefts++;
            }
            leftt++;
        }

        return lefts == s.length();
    }
}
