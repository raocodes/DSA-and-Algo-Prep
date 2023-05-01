package striver_og.arrays_ii;

// https://leetcode.com/problems/find-the-duplicate-number/
public class _4_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Naive approach would be to sort the array and linearly traverse
        // The solution we want should not modify the array

        // Since we do not want to modify the array we can maintain a count in another
        // array
        // So element 3's count in index 3
        // This is not constant extra space though

        // We use a slow pointer and fast pointer approach
        // If we to the index told in the value of the array we can make a cycle

        // For [1,3,4,2,2]: 0 -> 1 ->3 ->2 ->4 ->2 . Therefore cycle

        // We can do a slow and fast approach because for sure there is a duplicate

        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // When the loop has exited we are at the point of collision

        int pointer = 0;
        while (nums[pointer] != nums[slow]) {
            pointer = nums[pointer];
            slow = nums[slow];
        }

        return nums[pointer];
    }
}
