package leetcode_sheet.strings_medium;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _1_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                max = Integer.max(curr, max);
                left = Math.max(map.get(s.charAt(right)) + 1, left);
                curr = right - left + 1;
                map.put(s.charAt(right), right);
            } else {
                curr++;
                map.put(s.charAt(right), right);
            }
        }
        max = Integer.max(curr, max);

        return max;
    }
}
