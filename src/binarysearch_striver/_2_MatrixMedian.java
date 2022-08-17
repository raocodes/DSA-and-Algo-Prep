package binarysearch_striver;

// https://www.interviewbit.com/problems/matrix-median/
public class _2_MatrixMedian {
    public int countSmallerThanMid(int[] A, int target, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    public int findMedian(int[][] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] row : A) {
            for (int element : row) {
                min = Math.min(min, element);
                max = Math.max(max, element);
            }
        }

        int low = min;
        int high = max;
        int n = A.length;
        int m = A[0].length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerThanMid(A[i], mid, m);
            }
            if (count <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
