package searching;

import java.util.Scanner;

public class _3_InsertionSort {
	// Time complexity is O(n^2) - Quadratic
	// It is an in-place algorithm
	// It is stable

	// Just like the others it partitions into sorted and unsorted
	// Here the sorted partition is grown from the beginning of the array
	// It starts with first element in sorted partition
	// Each iteration we insert one element into the sorted partition
	// We take element from the unsorted part and compare it with all the elements
	// in the sorted from right to left
	// When we find it's place we insert it
	public static void main(String[] args) {
		int[] intArray = new int[50]; // 20 35 -15 7 55 1 -22
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = in.nextInt();
		System.out.println("Enter the values of the array: ");
		for (int a = 0; a < size; a++) {
			intArray[a] = in.nextInt();
		}

		for (int firstUnsortedIndex = 1; firstUnsortedIndex < size; firstUnsortedIndex++) {
			int newElement = intArray[firstUnsortedIndex];
			int i;
			for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--)
				intArray[i] = intArray[i - 1];
			intArray[i] = newElement;
		}

		System.out.print("Sorted array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + " ");
		}
		in.close();
	}
}
