package arrays_striver_iv;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _6_LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
