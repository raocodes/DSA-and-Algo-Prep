package searching;

public class MergeSort {
    // O(nlogn)

    public static void conquer(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];

        int indexone = start;
        int indextwo = mid + 1;
        int indexmerged = 0;

        while (indexone <= mid && indextwo <= end) {
            if (arr[indexone] <= arr[indextwo]) {
                merged[indexmerged++] = arr[indexone++];
            } else {
                merged[indexmerged++] = arr[indextwo++];
            }
        }

        // To add the remaining values
        while (indexone <= mid) {
            merged[indexmerged++] = arr[indexone++];
        }

        while (indextwo <= end) {
            merged[indexmerged++] = arr[indextwo++];
        }

        for(int i = 0, j = start; i < merged.length; i++, j++){
            arr[j] = merged[i];
        }
    }

    public static void divide(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conquer(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 3, 9, 5, 2, 8 };
        int n = arr.length;
        divide(arr, 0, n - 1);
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
