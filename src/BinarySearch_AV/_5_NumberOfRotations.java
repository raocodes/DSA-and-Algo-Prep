package BinarySearch_AV;

public class _5_NumberOfRotations {
    int findKRotation(int arr[], int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
