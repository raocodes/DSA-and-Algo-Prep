package leetcode_sheet.arrays_easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class _12_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int size = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index - 1] == nums[i]) {
                size--;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        return size;
    }
}
