package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/binary-search/1
public class _1_BinarySearch {
    int binarysearch(int arr[], int n, int k) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2); // To prevent overflow
            if (arr[mid] == k) return mid;
            else if (k < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
