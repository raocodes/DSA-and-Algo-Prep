package sorting;

public class InsertionSort {
    // O(n^2)
    // Stable
    public static void main(String[] args) {
        int[] arr = new int[] { 6, 3, 9, 5, 2, 8 };

        for (int i = 1; i < arr.length; i++) {
            // 0 is the sorted area
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
