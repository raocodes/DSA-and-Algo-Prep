package others.leetcode_sheet.easy.arrays;

import java.util.List;
import java.util.ArrayList;

public class _11_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int a = 0; a < numRows; a++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int b = 0; b < a + 1; b++) {
                if (b == 0 || b == a) {
                    row.add(1);
                } else {
                    row.add(triangle.get(a - 1).get(b - 1) + triangle.get(a - 1).get(b));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
