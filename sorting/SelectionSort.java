package sorting;

public class SelectionSort {
    // O(n ^ 2)
    // Unstable

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 3, 9, 5, 2, 8 };

        for (int i = 0; i < arr.length - 1; i++) {
            // arr.length - 1 because when there is one element left no need to sort
            // The array is already sorted then
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
