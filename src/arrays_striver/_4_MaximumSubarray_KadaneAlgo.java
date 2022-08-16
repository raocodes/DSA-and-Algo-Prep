package arrays_striver;

// https://leetcode.com/problems/maximum-subarray/
public class _4_MaximumSubarray_KadaneAlgo {
    public int maxSubArray(int[] nums) {
        // THIS IS KADANE'S ALGORITHM
        // The inefficient approach would be to just loop through everything

        // In kadane's algorithm we go from left to right in the array

        // If when adding the current element the sum becomes -ve we set sum = 0
        // We go to the next element
        // This means that we are basically dropping the previous subarray

        // Before reseting to 0 if it is the maxsum we still do a math max and take it
        // This works if all the elements are negative then we still need a max sum
        // If everything is negative then basically the max subarray is size 1

        // Otherwise we add and if the sum is now greater than max sum we update max sum
        // This way we can find the max subarray sum

        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxsum = Math.max(maxsum, sum);
            if (sum < 0) {
                // We ditch the subarray since it resulted in negative
                sum = 0;
            }
        }
        return maxsum;
    }
}
