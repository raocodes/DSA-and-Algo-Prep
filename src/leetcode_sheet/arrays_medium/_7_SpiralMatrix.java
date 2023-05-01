package leetcode_sheet.arrays_medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class _7_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int xend = matrix[0].length - 1;
        int yend = matrix.length - 1;
        int xstart = 0;
        int ystart = 0;

        int total = matrix[0].length * matrix.length;
        int count = 0;
        List<Integer> result = new ArrayList<>();

        while (count <= total) {
            for (int i = xstart; i <= xend; i++) {
                result.add(matrix[ystart][i]);
                count++;
            }

            if (count == total) {
                break;
            }

            for (int i = ystart + 1; i <= yend; i++) {
                result.add(matrix[i][xend]);
                count++;
            }

            if (count == total) {
                break;
            }

            for (int i = xend - 1; i >= xstart; i--) {
                result.add(matrix[yend][i]);
                count++;
            }

            if (count == total) {
                break;
            }

            for (int i = yend - 1; i > ystart; i--) {
                result.add(matrix[i][xstart]);
                count++;
            }

            xstart++;
            ystart++;
            yend--;
            xend--;
        }

        return result;
    }
}
