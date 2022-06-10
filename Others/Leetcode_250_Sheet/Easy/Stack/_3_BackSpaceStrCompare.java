package Others.Leetcode_250_Sheet.Easy.Stack;

import java.util.Stack;

public class _3_BackSpaceStrCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stks = new Stack<>();
        Stack<Character> stkt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '#') {
                if (!stks.isEmpty()) {
                    stks.pop();
                }
            } else {
                stks.add(curr);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (curr == '#') {
                if (!stkt.isEmpty()) {
                    stkt.pop();
                }
            } else {
                stkt.add(curr);
            }
        }

        if (stkt.size() != stks.size()) {
            return false;
        } else {
            while (!stkt.isEmpty()) {
                if (stkt.pop() != stks.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
