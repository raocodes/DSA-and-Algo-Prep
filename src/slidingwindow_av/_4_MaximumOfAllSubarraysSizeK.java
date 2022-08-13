package slidingwindow_av;

import java.util.Deque;
import java.util.LinkedList;

public class _4_MaximumOfAllSubarraysSizeK {
    public int[] slidingMaximum(final int[] A, int B) {
        Deque<int[]> dq = new LinkedList<>();
        int[] result = new int[A.length - B + 1];

        for (int currindex = 0; currindex < A.length; currindex++) {
            while (!dq.isEmpty() && dq.peekFirst()[1] <= currindex - B) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && dq.peekLast()[0] <= A[currindex]) {
                dq.pollLast();
            }

            dq.offerLast(new int[] { A[currindex], currindex });
            if (currindex >= B - 1) {
                result[currindex - B + 1] = dq.peekFirst()[0];
            }
        }

        return result;
    }
}
