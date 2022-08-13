package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
public class _7_FloorInSortedArray {
    static int findFloor(long arr[], int n, long x) {
        int start = 0;
        int end = n - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2); // To prevent overflow
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }
}
