package neetcode.binary_search;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class _5_FindMinimumInRotatedSorted {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            // System.out.println(start + " " + end + " " + mid);

            if (nums[start] < nums[end]) {
                // It is sorted
                // So first will be the obvious answer
                return nums[start];
            }

            // If it is the smallest element
            // It will have bigger elements on it's left and right
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return nums[mid];
            }

            if (nums[start] <= nums[mid]) {
                // If the beginning is lesser than or equal to mid
                // The right is unsorted
                start = mid + 1;
            } else if (nums[end] >= nums[mid]) {
                // If the end is greater than or equal to mid
                // The left is unsorted
                end = mid - 1;
            }
        }

        return -1;
    }
}
