package aditya_verma.binary_search;

// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class _15_AllocateMinimumPages {
    private static boolean isValid(int[] A, int N, int M, int max) {
        int count = 0;
        int index = 0;
        int sum = 0;
        while (count < M && index < N) {
            sum += A[index];
            if (sum > max) {
                sum = 0;
                count++;
            } else {
                index++;
            }
        }

        return index == N;
    }

    public static int findPages(int[] A, int N, int M) {
        // We start from the max of all elements
        // End at the sum of all elemenets
        // This is because between this range the answer exists
        // We are searching for the minimum max value of pages
        // when we have partitioned the array for the students
        // For 113, 12 + 34 + 67
        // All books NEED to be allocated and every student should have a book
        // A does NOT need to be sorted

        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int page : A) {
            end += page;
            start = Math.max(start, page);
        }
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // When we find mid, it is considered as the max pages a student can read

            if (isValid(A, N, M, mid)) {
                // If we are able to allocate all the pages we store the result
                // Then we move to the left to see if we can find a smaller value
                result = mid;
                end = mid - 1;
            } else {
                // If we are unable to allocate all the pages then we need more students
                // Not possible so in that case we increase mid;
                start = mid + 1;
            }
        }

        return result;
    }
}
