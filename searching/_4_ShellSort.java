package searching;

import java.util.Scanner;

public class _4_ShellSort {
	// Time complexity is O(n^2) - Quadratic but it could be better than insertion
	// It is an in-place algorithm
	// It is unstable

	// If most of the values are already sorted in insertion sort we can reduce
	// shifting
	// Goal is to reduce the amount of shitfing required
	// In insertion sort we start with a gap value of 1 and stay with that
	// here we start with a bigger one and as the algorithm progresses it reduces
	// When the gap is 1 again it is the equivalent of insertion sort. That is one
	// element is fitted
	// By the time the shell sort becomes insertion it is already partially sorted

	// Gap can be calculated using Knuth Sequence = (3^k - 1) / 2
	// We need to take k such that the it fits in the sequence

	// We are going to use a different method for gaps
	// We take gap as length of arrray by 2
	// We update the gap by dividing the length by 2

	/*
	 * 20 35 -15 7 55 1 -22 i = gap = 3 j = i = 3 newElement = intArray[i] = 7
	 * Compare intArray[j - gap] with newElement as the gap is 3 and not 1
	 * 
	 * After 1st iteration, 7 35 -15 20 55 1 -22 i = 4 j = i = 4 newElement =
	 * intArray[i] = 55 Compare intArray[j - gap] with newElement NOTHING HAPPENS as
	 * 55 > 35
	 * 
	 * Then, 7 35 -15 20 55 1 -22
	 * 
	 * Then again, 7 35 -15 20 55 1 -22 -22 < 20 and -22 < 7
	 * 
	 * Now, -22 35 -15 7 55 1 20 With this we finished iteration with gap 3 After
	 * this gap is 1 and i = gap = 1 With this it is just the normal insertion sort
	 */
	public static void main(String[] args) {
		int[] intArray = new int[50]; // 20 35 -15 7 55 1 -22
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = in.nextInt();
		System.out.println("Enter the values of the array: ");
		for (int a = 0; a < size; a++) {
			intArray[a] = in.nextInt();
		}

		for (int gap = size / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < size; i++) {
				int newElement = intArray[i];
				int j;
				for (j = i; j >= gap && intArray[j - gap] > newElement; j -= gap) {
					intArray[j] = intArray[j - gap];
				}
				intArray[j] = newElement;
			}
		}

		System.out.print("Sorted array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(intArray[i] + " ");
		}
		in.close();
	}
}
