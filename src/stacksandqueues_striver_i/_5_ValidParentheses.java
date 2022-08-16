package stacksandqueues_striver_i;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class _5_ValidParentheses {
    public boolean isValid(String s) {
        // types are (, { and [
        Stack<Character> stk = new Stack<>();

        Map<Character, Character> balance = new HashMap<>();
        balance.put(')', '(');
        balance.put('}', '{');
        balance.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stk.push(curr);
            } else if (curr == ')' || curr == '}' || curr == ']') {
                if (!stk.isEmpty() && stk.peek() == balance.get(curr)) {
                    stk.pop();
                } else {
                    stk.push(curr);
                }
            }
        }

        return stk.isEmpty();
    }
}
