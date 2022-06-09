package BinarySearch_AV;

public class _2_OrderAgnosticBinarySearch {
    int binarysearch(int arr[], int n, int k) {
        int start = 0;
        int end = n - 1;
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + ((end - start) / 2); // To prevent overflow
            if (arr[mid] == k) return mid;

            if (isAsc) {
                if (arr[mid] < k) start = mid + 1;
                else end = mid - 1;
            } else {
                if (arr[mid] > k) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}