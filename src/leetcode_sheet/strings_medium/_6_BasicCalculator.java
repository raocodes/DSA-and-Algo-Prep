package leetcode_sheet.strings_medium;

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
                int temp = i + 1;
                while (temp < s.length() && !isOperatorOrSpace(s.charAt(temp))) {
                    temp++;
                }

                int num = Integer.parseInt(s.substring(i, temp));
                i = temp - 1;

                if (op == '*') {
                    int op1 = stk.pop();
                    stk.push(op1 * num);
                } else if (op == '/') {
                    int op1 = stk.pop();
                    stk.push(op1 / num);
                } else if (op == '-') {
                    stk.push(-num);
                } else {
                    stk.push(num);
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
