package striver_og.arrays_ii;

// https://www.interviewbit.com/problems/repeat-and-missing-number-array/
public class _5_RepeatAndMissingNumber {
    public int[] repeatedNumber(final int[] A) {
        int[] copy = A.clone();

        int duplicate = -1;
        for (int i = 0; i < copy.length; i++) {
            int num = Math.abs(copy[i]);

            if (copy[num - 1] < 0) {
                // Already marked once
                duplicate = num;
                continue;
            }

            copy[num - 1] = -copy[num - 1];
        }

        int nofound = -1;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] > 0) {
                nofound = i + 1;
            }
        }

        return new int[]{duplicate, nofound};
    }
}
