package sorting;

public class BubbleSort {
    // O(n ^ 2)

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 3, 9, 5, 2, 8 };

        for (int i = 0; i < arr.length - 1; i++) {
            // arr.length - 1 because when there is one element left no need to sort
            // The array is already sorted then
            for (int j = 1; j < arr.length - i; j++) {
                // arr.length - i are already sorted
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
