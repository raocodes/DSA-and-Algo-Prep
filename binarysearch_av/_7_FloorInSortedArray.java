package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
public class _7_FloorInSortedArray {
    static int findFloor(long arr[], int n, long x) {
        int start = 0;
        int end = n - 1;
        int mid = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2); // To prevent overflow
            if (arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        if (arr[mid] > x) {
            return -1;
        }

        return mid;
    }
}
