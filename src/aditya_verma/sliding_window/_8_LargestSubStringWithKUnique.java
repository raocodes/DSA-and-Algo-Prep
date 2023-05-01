package aditya_verma.sliding_window;

import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
public class _8_LargestSubStringWithKUnique {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = -1;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.size() == k) {
                max = Math.max(max, right - left + 1);
            }

            while (map.size() > k) {
                int curr = map.get(s.charAt(left));
                if (curr == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), curr - 1);
                }
                left++;
            }
        }

        return max;
    }
}
