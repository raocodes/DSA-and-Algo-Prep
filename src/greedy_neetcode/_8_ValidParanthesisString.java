package greedy_neetcode;

import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string/
public class _8_ValidParanthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> stkbr = new Stack<>();
        Stack<Integer> stkstr = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ')') {
                if (!stkbr.isEmpty()) {
                    stkbr.pop();
                } else if (!stkstr.isEmpty() && stkstr.peek() < i) {
                    stkstr.pop();
                } else {
                    return false;
                }
            } else if (curr == '(') {
                stkbr.push(i);
            } else {
                stkstr.push(i);
            }
        }

        while (!stkbr.isEmpty() && !stkstr.isEmpty() && stkstr.peek() > stkbr.peek()) {
            stkbr.pop();
            stkstr.pop();
        }

        return stkbr.isEmpty();
    }
}
