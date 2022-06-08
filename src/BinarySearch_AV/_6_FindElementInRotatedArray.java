package BinarySearch_AV;

// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class _6_FindElementInRotatedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (target > nums[nums.length - 1]) {
            end = start - 1;
            start = 0;
        } else {
            end = nums.length - 1;
        }

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
