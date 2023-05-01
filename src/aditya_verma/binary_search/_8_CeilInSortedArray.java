package aditya_verma.binary_search;

// https://www.codingninjas.com/codestudio/problems/ceiling-in-a-sorted-array_1825401?leftPanelTab=1
public class _8_CeilInSortedArray {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int start = 0;
        int end = n - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2); // To prevent overflow
            if (arr[mid] == x) {
                return arr[mid];
            } else if (arr[mid] > x) {
                end = mid - 1;
                res = arr[mid];
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}
