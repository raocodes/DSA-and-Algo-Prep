import java.util.Stack;

// https://leetcode.com/problems/basic-calculator/submissions/
public class BasicCalculator {
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

            if (s.charAt(i) == '(') {
                int oldi = i;
                i++;
                int open = 1;
                while (i < s.length() && open != 0) {
                    if (s.charAt(i) == '(') {
                        open++;
                    } else if (s.charAt(i) == ')') {
                        open--;
                    }
                    i++;
                }

                if (oldi + 1 != i - 1) {
                    if (op == '-') {
                        stk.push(-calculate(s.substring(oldi + 1, i - 1)));
                    } else {
                        stk.push(calculate(s.substring(oldi + 1, i - 1)));
                    }
                }
                i--;
            } else if (!isOperatorOrSpace(s.charAt(i))) {
                int oldi = i;
                i++;
                while (i < s.length() && !isOperatorOrSpace(s.charAt(i))) {
                    i++;
                }

                int num = Integer.parseInt(s.substring(oldi, i--));

                if (op == '-') {
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
