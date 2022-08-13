package binarysearch_av;

// https://practice.geeksforgeeks.org/problems/rotation4723/1/
public class _5_NumberOfRotations {
    int findKRotation(int arr[], int n) {
        // If the array was rotated in clockwise then we do return n - mid

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;

            // System.out.println(start + " " + end + " " + mid);

            if (arr[start] < arr[end]) {
                // It is sorted
                // So first will be the obvious answer
                return start;
            }

            // If it is the smallest element
            // It will have bigger elements on it's left and right
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            if (arr[start] <= arr[mid]) {
                // If the beginning is lesser than or equal to mid
                // The right is unsorted
                start = mid + 1;
            } else if (arr[end] >= arr[mid]) {
                // If the end is greater than or equal to mid
                // The left is unsorted
                end = mid - 1;
            }
        }

        return 0;
    }
}
