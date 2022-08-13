package striver_sheet.stacksandqueues_ii;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/
public class _5_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // We can do a naive approach and go 3 elements are a time
        // Outer will be 0 to length - 3
        // Inner reads all 3 and tells us
        // This is not an efficient approach

        // This follows an approach similar to nearest greatest element

        // We go from the left and try to find the nearest greatest
        // We cannot use a stack because we need nearest greatest with only 3 elements
        // at a time

        int[] result = new int[nums.length - k + 1];
        int resultindex = 0;
        Deque<Integer> queue = new LinkedList<>();

        // The queue contains index of the max value in the current bound
        for (int i = 0; i < nums.length; i++) {
            // We get rid of all queue values that are not in bounds
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            // Before adding our current element we remove everything that is smaller than
            // it
            // If the element we are adding is smaller than the element in the queue then
            // simply add it
            // This is because if even more smaller values follow then this smallest will
            // simply be the biggest
            // If something big comes then anyway this small will go

            // Get rid of all values smaller than current from behind, front could till have
            // something bigger
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            if (i >= k - 1) {
                // Only from the 2nd index onwards we save values
                result[resultindex++] = nums[queue.peekFirst()];
            }
        }

        return result;
    }
}
