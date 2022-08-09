package binarysearch_av;

public class _10_FindPositionInSortedInfiniteArray {
    public static int binarySearch(int[] a, int target) {
        int start = 0;
        int end = 1;

        // First try to find the lower and upper bounds before applying binary search
        while (target > a[end]) {
            // We keep extending till the target is within bounds
            start = end;
            end *= 2;
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
