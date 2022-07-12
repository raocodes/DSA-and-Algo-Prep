package leetcode_sheet.medium.stack;

import java.util.Stack;

public class _2_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        // In this solution we are finding nearest greatest to the right
        Stack<Integer[]> stk = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int a = temperatures.length - 1; a >= 0; a--) {
            if (stk.isEmpty()) {
                result[a] = 0;
            } else if (stk.peek()[0] > temperatures[a]) {
                result[a] = stk.peek()[1] - a;
            } else {
                while (!stk.isEmpty() && stk.peek()[0] <= temperatures[a]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    result[a] = 0;
                } else {
                    result[a] = stk.peek()[1] - a;
                }
            }
            stk.add(new Integer[]{temperatures[a], a});

        }
        return result;
    }
}
