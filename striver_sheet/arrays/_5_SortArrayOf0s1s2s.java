package striver_sheet.arrays;

// https://leetcode.com/problems/sort-colors/
public class _5_SortArrayOf0s1s2s {
    public void sortColors(int[] nums) {
        // The first approach would be to simple Arrays.sort()
        // That will have nlogn time complexity

        // Rather than that we can have a count of 0s, 1s, 2s
        // We use that to create our result
        // This has O(2N)

        // This is still not the most efficient
        // We try to sort in one iteration itself

        // We will have low, mid and high pointers
        // Between 0 and low is 0
        // Between low and mid is 1
        // Between high and end is 2

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 1) {
                mid++;
                // If it is 1 then we just increased mid
                // It can only be found by low
                // Therefore after exchanging low and mid for 0 we increase mid also
                // Because surely what is left behind is a 1
                // 2 is always sent away to the end
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
                // We do not decrement mid because
                // processing is still left the for new element
            } else if (nums[mid] == 0) {
                // We found a 0, it needs to be moved to low
                // low needs to increment and so does mid
                // This is because whatever is left behind at low HAS to be 1
                swap(nums, low, mid);
                low++;
                mid++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
