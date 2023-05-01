package striver_og.arrays_ii;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/
public class _3_Merge2SortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = 0;
        int pointer2 = 0;

        if (n == 0)
            return;

        while (pointer1 < m) {
            if (nums1[pointer1] <= nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                int temp = nums1[pointer1];
                nums1[pointer1] = nums2[pointer2];
                nums2[pointer2] = temp;
                pointer1++;
                Arrays.sort(nums2);
            }
        }

        while (pointer2 < n) {
            nums1[pointer1++] = nums2[pointer2++];
        }
    }
}
