package leetcode_sheet.arrays_easy;

// https://leetcode.com/problems/move-zeroes/
public class _4_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int prev = 0;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] == 0) {
                curr++;
                continue;
            }
            nums[prev] = nums[curr];
            prev++;
            curr++;
        }
        while (prev < nums.length) {
            nums[prev] = 0;
            prev++;
        }
    }
}
