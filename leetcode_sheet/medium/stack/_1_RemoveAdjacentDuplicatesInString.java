package leetcode_sheet.medium.stack;

import java.util.Stack;

public class _1_RemoveAdjacentDuplicatesInString {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charstk = new Stack<>();
        Stack<Integer> countstk = new Stack<>();

        for (int a = 0; a < s.length(); a++) {
            char curr = s.charAt(a);
            if (!charstk.isEmpty() && charstk.peek() == curr) {
                countstk.add(countstk.pop() + 1);
            } else {
                countstk.add(1);
            }
            charstk.add(curr);

            if (countstk.peek() == k) {
                for (int i = 0; i < k; i++) {
                    charstk.pop();
                }
                countstk.pop();
            }
        }

        char[] result = new char[charstk.size()];
        int a = result.length - 1;
        while (!charstk.isEmpty()) {
            result[a] = charstk.pop();
            a--;
        }
        return String.valueOf(result);
    }
}
