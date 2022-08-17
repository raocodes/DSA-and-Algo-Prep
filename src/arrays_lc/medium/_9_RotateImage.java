package arrays_lc.medium;

// https://leetcode.com/problems/rotate-image/
public class _9_RotateImage {
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
}
