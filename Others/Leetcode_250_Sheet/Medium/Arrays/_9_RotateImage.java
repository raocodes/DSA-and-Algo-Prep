package Others.Leetcode_250_Sheet.Medium.Arrays;

public class _9_RotateImage {
    public void rotate(int[][] matrix) {
        int temp;
        int size = matrix.length;
        int offset = 0;

        while (offset < size / 2) {
            temp = matrix[offset][offset];
            matrix[offset][offset] = matrix[offset][size - 1 - offset];
            matrix[offset][size - 1 - offset] = temp;

            temp = matrix[offset][offset];
            matrix[offset][offset] = matrix[size - 1 - offset][offset];
            matrix[size - 1 - offset][offset] = temp;

            for (int a = offset + 1; a < size - 1 - offset; a++) {
                temp = matrix[offset][size - 1 - a];
                matrix[offset][size - 1 - a] = matrix[a][offset];
                matrix[a][offset] = temp;
            }

            for (int a = offset + 1; a < size - 1 - offset; a++) {
                temp = matrix[a][offset];
                matrix[a][offset] = matrix[size - 1 - a][size - 1 - offset];
                matrix[size - 1 - a][size - 1 - offset] = temp;
            }

            temp = matrix[size - 1 - offset][offset];
            matrix[size - 1 - offset][offset] = matrix[size - 1 - offset][size - 1 - offset];
            matrix[size - 1 - offset][size - 1 - offset] = temp;

            for (int a = offset + 1; a < size - 1 - offset; a++) {
                temp = matrix[a][offset];
                matrix[a][offset] = matrix[size - 1 - offset][a];
                matrix[size - 1 - offset][a] = temp;
            }
            offset++;
        }
    }
}
