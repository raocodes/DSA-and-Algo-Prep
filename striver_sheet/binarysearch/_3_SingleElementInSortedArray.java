package striver_sheet.binarysearch;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class _3_SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // Naive approach would be to linearly go and do XOR
        // In XOR if there are 2 different values XORed then we get 1 otherwise 0

        // We use binary search to find breakpoint where to the left all double
        // to the right first element is single then again double

        // On left side, first instance of double number is at even index
        // On right side, first instance of double number is at odd index

        int low = 0;
        int high = nums.length - 2;
        // We skip one because if the last element is the single one
        // low will go to the last element
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // We are trying to find the left half
            // Odd XOR 1 gives even before it
            // 3 (11) XOR 1 gives 2 (10)
            // Even XOR 1 gives odd after it
            // 2 (10) XOR 1 gives 3 (11)
            // This gives us exactly what we want to find the left part
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Just before exiting the loop both the low and high are at the same place
        // When that happens the high changes and the loop exits
        return nums[low];
    }
}
