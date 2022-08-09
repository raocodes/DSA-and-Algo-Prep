package binarysearch_av;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class _6_FindElementInRotatedArray {
    private int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid + nums.length - 1) % nums.length;
            int next = (mid + 1) % nums.length;

            if (nums[start] < nums[end]) {
                result = start;
                break;
            }

            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                result = mid;
                break;
            }

            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else if (nums[end] >= nums[mid]) {
                end = mid - 1;
            }
        }

        return result;
    }

    private int bSearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int left = bSearch(nums, 0, pivot - 1, target);
        int right = bSearch(nums, pivot, nums.length - 1, target);

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right;
        } else {
            return left;
        }
    }
}
