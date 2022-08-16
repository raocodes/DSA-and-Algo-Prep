package strings_striver;

import java.util.Stack;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class _1_ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim() + " ";
        Stack<String> stk = new Stack<>();

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stk.push(s.substring(start, i));
                while (i < s.length() - 1 && s.charAt(i + 1) == ' ') {
                    i++;
                }
                start = i + 1;
            }
        }

        String toreturn = "";
        while (!stk.isEmpty()) {
            toreturn = toreturn + stk.pop() + " ";
        }

        return toreturn.trim();
    }
}
