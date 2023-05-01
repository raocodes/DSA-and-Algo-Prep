package leetcode_sheet.strings_medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class _5_GenerateParenthesis {
    public void find(int index, String s, int limit, int open, int closed, List<String> result) {
        if (index == limit * 2) {
            if (open == closed) {
                result.add(s);
            }
            return;
        }

        if (open < limit) {
            find(index + 1, s + "(", limit, open + 1, closed, result);
        }
        if (closed < open) {
            find(index + 1, s + ")", limit, open, closed + 1, result);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        find(0, "", n, 0, 0, result);
        return result;
    }
}
