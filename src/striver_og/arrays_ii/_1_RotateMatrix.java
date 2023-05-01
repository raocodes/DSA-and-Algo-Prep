package striver_og.arrays_ii;

// https://leetcode.com/problems/rotate-image/
public class _1_RotateMatrix {
    public void rotate(int[][] matrix) {
        // We simply perform a transpose of the matrix
        // Then we reverse each row of the matrix

        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                // We need to use i + 1 because it is inplace
                // We do not need to act on other columns because it is already swapped
                swap(matrix, i, j, j, i);
            }
        }

        // Reverse
        for (int[] row : matrix) {
            int start = 0;
            int end = row.length - 1;
            while (start < end) {
                swaprow(row, start++, end--);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int ir, int jr) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[ir][jr];
        matrix[ir][jr] = temp;
    }

    public void swaprow(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }

    // My method
    public void rotateMyMethod(int[][] matrix) {
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
