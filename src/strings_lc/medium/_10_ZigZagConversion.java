package strings_lc.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/
public class _10_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<List<Character>> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<Character>());
        }

        int rowcount = 0;
        boolean rev = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(rowcount).add(s.charAt(i));

            if (rev) {
                rowcount--;
            } else {
                rowcount++;
            }

            if (rowcount == numRows) {
                rowcount = rowcount - 2;
                rev = true;
            }

            if (rowcount == -1) {
                rowcount = rowcount + 2;
                rev = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (List<Character> row : rows) {
            for (char entry : row) {
                res.append(entry);
            }
        }

        return res.toString();
    }
}
