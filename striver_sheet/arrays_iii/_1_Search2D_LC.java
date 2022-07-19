package striver_sheet.arrays_iii;

// https://leetcode.com/problems/search-a-2d-matrix/
public class _1_Search2D_LC {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            }
        }
        return false;
    }
}
