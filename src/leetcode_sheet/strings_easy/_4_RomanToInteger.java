package leetcode_sheet.strings_easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/
public class _4_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> characters = new HashMap<>();
        characters.put('I', 1);
        characters.put('V', 5);
        characters.put('X', 10);
        characters.put('L', 50);
        characters.put('C', 100);
        characters.put('D', 500);
        characters.put('M', 1000);

        int sum = 0, previous = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = characters.get(s.charAt(i));
            if (previous * 4 < curr) {
                sum = sum - previous - previous;
            }
            sum += curr;
            previous = curr;
        }

        return sum;
    }
}
