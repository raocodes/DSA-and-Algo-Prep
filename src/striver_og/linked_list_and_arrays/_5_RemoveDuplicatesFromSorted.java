package striver_og.linked_list_and_arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class _5_RemoveDuplicatesFromSorted {
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
