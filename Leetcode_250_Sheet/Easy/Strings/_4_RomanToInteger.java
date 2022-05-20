package Leetcode_250_Sheet.Easy.Strings;

import java.util.HashMap;
import java.util.Map;

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

        int sum = 0, previous = 0, curr;
        for (char ch : s.toCharArray()) {
            curr = characters.get(ch);
            sum += curr;
            if (previous * 4 < curr) {
                sum -= 2 * previous;
            }
            previous = curr;
        }
        return sum;
    }
}
