package aditya_verma.dp._4_matrixchainmultiplication;

// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1/
public class _1_MatrixChainMultiplication_recursive {
    static int findMin(int[] arr, int i, int j) {
        if (i >= j) {
            // If there is only one element left then we cannot form a matrix
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = findMin(arr, i, k) + findMin(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    static int matrixMultiplication(int N, int arr[]) {
        return findMin(arr, 1, arr.length - 1);
    }
}
