package aditya_verma.stack;

import java.util.Stack;

public class _4_MaximumAreaHistogram {
    public static long getMaxArea(long hist[], long n) {
        Stack<Long[]> stk = new Stack<>();
        long[] nsr = new long[hist.length];
        long[] nsl = new long[hist.length];
        long max = 0;
        long temp;

        // NSR
        for (int i = hist.length - 1; i >= 0; i--) {
            if (stk.empty()) {
                nsr[i] = hist.length;
            } else {
                while (!stk.empty() && stk.peek()[0] >= hist[i]) {
                    stk.pop();
                }
                if (stk.empty()) {
                    nsr[i] = hist.length;
                } else {
                    nsr[i] = stk.peek()[1];
                }
            }
            stk.push(new Long[]{hist[i], (long) i});
        }

        stk.clear(); // Clearing stack before NSL

        // NSL
        for (int i = 0; i < hist.length; i++) {
            if (stk.empty()) {
                nsl[i] = -1;
            } else {
                while (!stk.empty() && stk.peek()[0] >= hist[i]) {
                    stk.pop();
                }
                if (stk.empty()) {
                    nsl[i] = -1;
                } else {
                    nsl[i] = stk.peek()[1];
                }
            }
            stk.push(new Long[]{hist[i], (long) i});
        }

        // Width
        for (int i = 0; i < hist.length; i++) {
            temp = (nsr[i] - nsl[i] - 1) * hist[i];
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
