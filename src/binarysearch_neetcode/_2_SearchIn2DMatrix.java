package binarysearch_neetcode;

// https://leetcode.com/problems/search-a-2d-matrix/
public class _2_SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int j = matrix[0].length - 1;
        int i = 0;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;

    }
}
