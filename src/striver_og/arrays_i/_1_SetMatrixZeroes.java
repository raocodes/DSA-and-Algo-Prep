package striver_og.arrays_i;

// https://leetcode.com/problems/set-matrix-zeroes/
public class _1_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // We use the 1st row and the 1st column.
        // It tells us if we need to change that row's and column's data to 0.
        // We ignore the first column when we are doing this
        // If I used the first column then all values will turn 0 in the first row if 1st column had a 0
        // This is because if a zero is present in the first column then [0][0] will be zero
        // Irrespective of what values are in there in the first row would have 0
        // Therefore we keep a flag which tells if it needs to be changed later on or not

        boolean changeCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                changeCol = true;
                // We need to change all the values in the column too
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (changeCol) {
                matrix[i][0] = 0;
            }
        }
    }
}
