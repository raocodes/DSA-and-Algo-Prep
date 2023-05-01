package leetcode_sheet.arrays_medium;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
public class _11_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MIN_VALUE;
        int currdiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (Math.abs(target - sum) < currdiff) {
                        result = sum;
                        currdiff = Math.abs(target - sum);
                    }
                    if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
    }
}
