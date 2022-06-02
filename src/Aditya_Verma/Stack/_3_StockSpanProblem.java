package Aditya_Verma.Stack;

import java.util.Stack;

public class _3_StockSpanProblem {
    public static int[] calculateSpan(int price[], int n) {
        int[] result = new int[n];
        Stack<Integer[]> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || (stk.peek()[0] > price[i])) {
                // Next immediate element is greater or does not exist so it is 1
                result[i] = 1;
            } else if (stk.peek()[0] <= price[i]) {
                while (!stk.isEmpty() && stk.peek()[0] <= price[i])
                    stk.pop();
                if (stk.isEmpty()) {
                    // If the stack is empty after all the popping then it is going to be greater
                    // than all the older elements
                    result[i] = i + 1;
                } else
                    result[i] = i - stk.peek()[1];
            }
            stk.push(new Integer[] { price[i], i });
        }
        return result;
    }
}
