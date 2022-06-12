package searching;

import java.util.Scanner;

public class _1_BubbleSort {
	// Time complexity is O(n^2) - Quadratic
	// It is an in-place algorithm

	// We compare each element with the next and swap if first is largest than
	// second
	// We keep doing this and therefore the last element in the array will be the
	// greatest
	// After that we run the code again for all elements apart from the last one
	// We keep reducing the size of the inner loop till we finish all the elements
	public static void main(String[] args) {
		int[] intArray = new int[50]; // 20 35 -15 7 55 1 -22
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = in.nextInt();
		System.out.println("Enter the values of the array: ");
		for (int a = 0; a < size; a++) {
			intArray[a] = in.nextInt();
		}

		// lastUnsortedIndex > 0 because when it is 1 only one element is left in the
		// unsorted part
		for (int lastUnsortedIndex = size - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			for (int i = 0; i < lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}

			}
		}

		System.out.print("Sorted array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + " ");
		}
		
		in.close();
	}

	public static void swap(int[] array, int i, int j) {
		// This needs to be static
		// Main cannot call swap() if it is not
		// If it is not static we need to define a _BubbleSort object
		if (i == j) {
			return;
		}
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}