package Stack_AV;

import java.util.Stack;

public class _5_MaximumAreaRectangleBinaryMatrix {
    public int maxArea(int M[][], int n, int m) {
        int temp;
        int[] hist = M[0];
        int max = getMaxArea(hist, m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (M[i][j] == 0) {
                    hist[j] = 0;
                } else {
                    hist[j] += M[i][j];
                }
            temp = getMaxArea(hist, m);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static int getMaxArea(int hist[], int n) {
        Stack<int[]> stk = new Stack<>();
        int[] nsr = new int[hist.length];
        int[] nsl = new int[hist.length];
        int max = 0;
        int temp;

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
            stk.push(new int[] { hist[i], (int) i });
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
            stk.push(new int[] { hist[i], (int) i });
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
