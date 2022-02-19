package Medium.Arrays;

import java.util.ArrayList;
import java.util.List;

public class _7_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int totalsize = matrix.length * matrix[0].length;
        int counter = 0;

        int leftcol = 0, rightcol = matrix[0].length - 1;
        int toprow = 0, bottomrow = matrix.length - 1;

        List<Integer> elements = new ArrayList<>();

        while (true) {
            for (int x = leftcol; x <= rightcol; x++) {
                elements.add(matrix[toprow][x]);
                counter++;
            }
            toprow++;

            if (counter == totalsize)
                break;

            for (int x = toprow; x <= bottomrow; x++) {
                elements.add(matrix[x][rightcol]);
                counter++;
            }
            rightcol--;

            if (counter == totalsize)
                break;

            for (int x = rightcol; x >= leftcol; x--) {
                elements.add(matrix[bottomrow][x]);
                counter++;
            }
            bottomrow--;

            if (counter == totalsize)
                break;

            for (int x = bottomrow; x >= toprow; x--) {
                elements.add(matrix[x][leftcol]);
                counter++;
            }
            leftcol++;

            if (counter == totalsize)
                break;
        }

        return elements;
    }
}
