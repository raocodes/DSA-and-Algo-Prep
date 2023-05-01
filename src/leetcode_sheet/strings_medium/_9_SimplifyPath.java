package leetcode_sheet.strings_medium;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/
public class _9_SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        path = path.concat("/");

        for (int i = 0; i < path.length() - 1; i++) {
            if (path.charAt(i) == '/') {
                i++;
                StringBuilder curr = new StringBuilder();

                while (path.charAt(i) != '/') {
                    curr.append(path.charAt(i));
                    i++;
                }
                i--;

                if (curr.toString().equals("..")) {
                    if (!stk.isEmpty()) {
                        stk.pop();
                    }
                } else if (!curr.toString().equals("") && !curr.toString().equals(".")) {
                    stk.push(curr.toString());
                }
            }
        }

        String result = "";
        while (!stk.isEmpty()) {
            result = stk.pop() + "/" + result;
        }

        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1);
        }

        return "/" + result;
    }
}
