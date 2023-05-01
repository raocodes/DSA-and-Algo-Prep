package leetcode_sheet.arrays_medium;

// https://leetcode.com/problems/next-permutation/
public class _6_NextPermutation {
    public void nextPermutation(int[] nums) {
        // The inefficient approach will be to use recursion and then find our combo and the one after that
        // We traverse from the end
        // We then find the first i where a[i] < a[i+1]
        // Then traverse from the end again
        // We find the first a[j] > a[i]
        // Then just swap them
        // Reverse everything to the right of i

        // This is an algorithm found here: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm

        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // if i == -1 then that means the entire thing is properly descending
        // We just need to reverse
        if (i >= 0) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }

        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
