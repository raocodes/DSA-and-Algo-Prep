package striver_og.stacks_and_queues_ii;

import java.util.Stack;

public class _1_NextSmallerElement {
    public int[] prevSmaller(int[] A) {
        // This is nearest smallest to the left
        // So we go from left to right

        Stack<Integer> stk = new Stack<>();
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!stk.isEmpty() && stk.peek() >= A[i]) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                result[i] = -1;
                stk.push(A[i]);
            } else {
                result[i] = stk.peek();
                stk.push(A[i]);
            }
        }

        return result;
    }
}
