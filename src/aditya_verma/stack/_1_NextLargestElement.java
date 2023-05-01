package aditya_verma.stack;

import java.util.Stack;

public class _1_NextLargestElement {
    // NEAREST GREATER TO RIGHT
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stk = new Stack<>();
        long[] sol = new long[n];

        for (int i = arr.length - 1; i >= 0; i--) {
            // First we check if the stack is empty
            if (stk.empty()) {
                sol[i] = -1;
            }
            // Then we check if the top element is greater, if so then we just use it
            else if (stk.peek() > arr[i]) {
                sol[i] = stk.peek();
            } else if (stk.peek() <= arr[i]) {
                // Since the top is smaller, we keep popping till the stack is either empty of
                // the top element is larger
                while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    sol[i] = -1;
                } else {
                    sol[i] = stk.peek();
                }
            }
            // We push the element we just checked to the stack
            stk.push(arr[i]);
        }
        return sol;
    }
}
