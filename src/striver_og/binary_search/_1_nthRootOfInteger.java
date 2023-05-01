package striver_og.binary_search;

// https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
public class _1_nthRootOfInteger {
    public static double multiply(double num, int times) {
        double result = 1;
        for (int i = 0; i < times; i++) {
            result *= num;
        }
        return result;
    }

    public static double findNthRootOfM(int n, long m) {
        // We take an array from 1 to m
        // The nth root will lie between 1 to m
        // We use binary search

        // In place of multiply we can use Pow(x,n) from array-iii

        if (n == 1 || m == 1) {
            return m;
        }

        double start = 1;
        double end = m;
        double accuracy = 0.0000001; // Allows us to be accurate upto 6 places
        double mid = 0;

        while (end - start > accuracy) {
            mid = start + (end - start) / 2;
            if (multiply(mid, n) > m) {
                // The result lies in the other half
                end = mid;
            } else {
                start = mid;
            }
        }

        return mid;
    }
}
