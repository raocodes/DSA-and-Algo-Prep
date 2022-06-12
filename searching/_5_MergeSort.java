package searching;

import java.util.Scanner;

public class _5_MergeSort {
	// Time complexity is O(nlogn) - base 2 as we are repeatedly dividing the array
	// in half during splitting
	// It is not an in-place algorithm
	// It is stable

	// It is divide and conquer
	// We usually do it recursively
	// Two phases: Splitting and Merging
	// We do sorting in merging but splitting is to speed up sorting
	// We logically split

	// Splitting Phase:
	// Divide into 2 arrays which are unsorted
	// Split the divided arrays
	// We keep splitting the arrays down till all arrays have only one element
	// Now we start merging the one-element arrays into 2 elements
	// Then 2 element arrays into 4 and so on
	// When merging we sort

	// IN THIS IMPLEMENTATION THE EXTRA MIDDlE NUMBER GOES TO THE RIGHT ARRAY
	// To merge we use a temporary array where we place the elements in the correct
	// order and then transfer back
	public static void main(String[] args) {
		int[] intArray = new int[50]; // 20 35 -15 7 55 1 -22
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = in.nextInt();
		System.out.println("Enter the values of the array: ");
		for (int a = 0; a < size; a++) {
			intArray[a] = in.nextInt();
		}

		mergeSort(intArray, 0, size);

		System.out.print("Sorted array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + " ");
		}
		in.close();
	}

	public static void mergeSort(int[] input, int start, int end) {
		// IN THIS IMPLEMENTATION THE END INDEX IS ONE GREATER THAN THE LAST ELEMENT
		if (end - start < 2) {
			// Only one element array the it is already sorted
			return;
		}

		int mid = (start + end) / 2;
		mergeSort(input, start, mid);
		mergeSort(input, mid, end);
		// At the end of these calls, the 2 partitions are sorted. We now merge the 2
		// partitions
		merge(input, start, mid, end);
	}

	public static void merge(int[] input, int start, int mid, int end) {
		// Some optimisations
		if (input[mid - 1] <= input[mid]) {
			return;
			// 2 arrays can be merged without sorting
		}

		int i = start; // Start of first subarray
		int j = mid; // Start of second subarray
		int tempIndex = 0;

		int[] temp = new int[end - start];
		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
			// The <= makes it stable
		}

		// Again optimisations
		// If elements are left in the left subarray we must copy them properly
		// if elements are left in the right subarray we leave them as it is already
		// sorted
		// {32, 34}, {33, 36}
		// {32, 33, 34}
		// If we finsihed the left array whatever is left in the right will be anyway
		// sorted and greater
		// If right array is finished we need to copy
		System.arraycopy(input, i, input, start + tempIndex, mid - i);
		// If we completely traversed the left array length would be 0 and so nothing
		// will happen
		System.arraycopy(temp, 0, input, start, tempIndex);
		// Copying only upto tempIndex [Optimisation]
	}
}
