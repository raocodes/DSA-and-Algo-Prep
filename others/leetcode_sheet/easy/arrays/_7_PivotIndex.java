package others.leetcode_sheet.easy.arrays;

public class _7_PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int elem : nums) {
            sum += elem;
        }
        for (int a = 0; a < nums.length; a++) {
            if (a != 0) {
                left += nums[a - 1];
            }
            if ((sum - left - nums[a]) == left)
                return a;
        }
        return -1;
    }
}
