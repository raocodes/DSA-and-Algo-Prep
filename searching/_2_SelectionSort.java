package searching;

import java.util.Scanner;

public class _2_SelectionSort {
	// When relative order of duplicate elements is not preserved it is unstable
	// sort
	// When relative order of duplicate elements is preserved it is stable sort

	// Time complexity is O(n^2) - Quadratic
	// It is an in-place algorithm

	// When we start the lastUnsortedIndex is the last element
	// We find the largest element in the unsorted array
	// We then exchange the largest in the unsorted with the lastUnsortedIndex
	// We then consider the second last as lastUnsortedIndex and carry on
	// We keep doing this till the array is sorted
	public static void main(String[] args) {
		int[] intArray = new int[50]; // 20 35 -15 7 55 1 -22
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = in.nextInt();
		System.out.println("Enter the values of the array: ");
		for (int a = 0; a < size; a++) {
			intArray[a] = in.nextInt();
		}

		for (int lastUnsortedIndex = size - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int largest = 0;
			for (int i = 1; i <= lastUnsortedIndex; i++) {
				if (intArray[largest] < intArray[i]) {
					largest = i;
				}
			}
			swap(intArray, lastUnsortedIndex, largest);
		}

		System.out.print("Sorted array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + " ");
		}
		in.close();
	}

	public static void swap(int[] array, int i, int j) {
		if (i == j) {
			return;
		}
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
