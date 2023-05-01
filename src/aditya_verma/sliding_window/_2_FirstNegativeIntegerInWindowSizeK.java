package aditya_verma.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class _2_FirstNegativeIntegerInWindowSizeK {
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] result = new long[N - K + 1];
        Deque<long[]> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            while (!dq.isEmpty() && dq.peekFirst()[1] <= i - K) {
                dq.pollFirst();
            }

            if (A[i] < 0)
                dq.offerLast(new long[]{A[i], i});

            if (i >= K - 1) {
                if (dq.isEmpty()) {
                    result[i - K + 1] = 0;
                } else {
                    result[i - K + 1] = dq.peekFirst()[0];
                }
            }
        }

        return result;
    }
}
