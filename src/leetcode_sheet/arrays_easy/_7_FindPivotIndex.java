package leetcode_sheet.arrays_easy;

// https://leetcode.com/problems/find-pivot-index/
public class _7_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int element : nums) {
            sum += element;
        }

        int currsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currsum == (sum - nums[i] - currsum)) {
                return i;
            }
            currsum += nums[i];
        }
        return -1;
    }
}
