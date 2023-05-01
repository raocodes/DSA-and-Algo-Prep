package neetcode.binary_search;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _7_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // We run binary search on the smaller of the 2 arrays
        int[] small;
        int[] large;

        if (nums1.length > nums2.length) {
            small = nums2;
            large = nums1;
        } else {
            small = nums1;
            large = nums2;
        }

        int total = small.length + large.length;
        int half = total / 2; // Usually median will be just after half
        // Or will be average of half and half + 1

        int left = 0;
        int right = small.length - 1;

        while (true) {
            int midsmall = (int) Math.floor((left + right) / 2.0);
            // We have negative indices so cannot truncate, we need to floor
            int midlarge = half - midsmall - 2; // -2 because this is 0 - based indexing

            // We find the current and next value in both small and large arrays
            // We also account for out of bounds
            // If the curr goes out of bounds then we set it to a VERY SMALL value
            // If the next goes out of bounds then we set it to a VERY HUGE value
            int smallcurr = (midsmall >= 0) ? small[midsmall] : Integer.MIN_VALUE;
            int smallnext = (midsmall + 1 < small.length) ? small[midsmall + 1] : Integer.MAX_VALUE;
            int largecurr = (midlarge >= 0) ? large[midlarge] : Integer.MIN_VALUE;
            int largenext = (midlarge + 1 < large.length) ? large[midlarge + 1] : Integer.MAX_VALUE;

            if (smallcurr <= largenext && largecurr <= smallnext) {
                // This would mean that our partitions are correct
                if (total % 2 == 1) {
                    // If odd number of elements then we do not need to find average
                    // We just take the minimum of the next elements
                    return Math.min(smallnext, largenext);
                } else {
                    // For even we need average
                    // Max of curr gives us the first middle element
                    // Min of the next gives us the second middle element
                    return (Math.max(smallcurr, largecurr) + Math.min(smallnext, largenext)) / 2.0;
                }
            } else if (smallcurr > largenext) {
                right = midsmall - 1;
            } else if (largecurr > smallnext) {
                left = midsmall + 1;
            }
        }
    }
}
