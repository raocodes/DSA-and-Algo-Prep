// https://practice.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1
public class MaximumProductSubsetOfArray {
    public static int findMaxProduct(int n, int[] arr) {
        if (n == 1) {
            return arr[0];
        }

        int negcount = 0;
        int smallestneg = Integer.MIN_VALUE;
        long prod = 1;
        int zerocount = 0;

        for (int num : arr) {
            if (num == 0) {
                zerocount++;
                continue;
            }

            if (num < 0) {
                negcount++;
                smallestneg = Math.max(smallestneg, num);
            }

            prod *= num;
            prod = prod % (1000000007);
        }

        if (zerocount == n) {
            return 0;
        }

        if (negcount % 2 != 0) {
            // If we only have one negative number and rest all zeroes
            // We need to return 0
            if (negcount == 1 && zerocount + 1 == n) {
                return 0;
            }
            prod = (prod / smallestneg);
        }

        return (int) prod % 1000000007;
    }
}
