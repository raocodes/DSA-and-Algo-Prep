package sorting;

public class QuickSort {
    // We use last element as the pivot
    // Pivot makes into 2 partitions, on the left smaller and on the right larger

    // Worst case time complexity: O(n^2)
    // Unstable
    // Worst case is when the pivot is the smallest or the largest element and it is
    // sorted
    // 1 2 3 4 5, then with pivot as 5 we have to do O(n)

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot is the last element in the array

        int i = low;
        for (int j = low; j < high; j++) {
            // High not included because we already have taken last as pivot
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, high, i);
        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(arr, low, high); // Function returns the correct position of pivot

        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 9, 5, 2, 8};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
