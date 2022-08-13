package strings_lc.medium;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/
public class _6_BasicCalculator {
    public boolean isOperatorOrSpace(char ch) {
        if (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != ' ') {
            return false;
        }
        return true;
    }

    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        char op = 'A';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            if (!isOperatorOrSpace(s.charAt(i))) {
                int oldi = i;
                int temp = i + 1;
                while (temp < s.length() && !isOperatorOrSpace(s.charAt(temp))) {
                    temp++;
                    i++;
                }

                stk.push(Integer.valueOf(s.substring(oldi, temp)));

                if (op == '*') {
                    int op1 = stk.pop();
                    int op2 = stk.pop();
                    stk.push(op2 * op1);
                }

                if (op == '/') {
                    int op1 = stk.pop();
                    int op2 = stk.pop();
                    stk.push(op2 / op1);
                }

                if (op == '-') {
                    stk.push(-stk.pop());
                }

            } else {
                op = s.charAt(i);
            }


        }

        int sum = 0;
        while (!stk.isEmpty()) {
            sum += stk.pop();
        }

        return sum;
    }
}
