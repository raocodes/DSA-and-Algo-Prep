package leetcode_sheet.strings_medium;

import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class _2_MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') {
                    stk.pop();
                } else {
                    stk.push(i);
                }
            }
        }


        StringBuilder res = new StringBuilder(s);

        while (!stk.isEmpty()) {
            res.deleteCharAt(stk.pop());
        }

        return res.toString();
    }
}
