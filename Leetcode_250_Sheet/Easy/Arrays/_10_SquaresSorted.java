package Leetcode_250_Sheet.Easy.Arrays;

import java.util.Arrays;

public class _10_SquaresSorted {
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        for (int a = 0; a < nums.length; a++) {
            squares[a] = (int) Math.pow(nums[a], 2);
        }
        Arrays.sort(squares);
        return squares;
    }
}
