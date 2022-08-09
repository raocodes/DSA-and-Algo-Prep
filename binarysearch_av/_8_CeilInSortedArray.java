package binarysearch_av;

// https://www.codingninjas.com/codestudio/problems/ceiling-in-a-sorted-array_1825401?leftPanelTab=1
public class _8_CeilInSortedArray {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int start = 0;
        int end = n - 1;
        int mid = -1;

        while (start <= end) {
            mid = start + ((end - start) / 2); // To prevent overflow
            if (arr[mid] == x)
                return arr[mid];
            else if (x < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        if (arr[mid] > x) {
            return arr[mid];
        }

        if (arr[mid] < x && mid == n - 1) {
            return -1;
        }

        return arr[mid + 1];
    }
}
