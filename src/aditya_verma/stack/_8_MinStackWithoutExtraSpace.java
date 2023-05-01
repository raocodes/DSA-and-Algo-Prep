package aditya_verma.stack;

import java.util.Stack;

public class _8_MinStackWithoutExtraSpace {
    int minEle;
    Stack<Integer> s = new Stack<>();

    /* returns min element from stack */
    int getMin() {
        if (s.isEmpty()) {
            return -1;
        }
        return minEle;
    }

    /* returns poped element from stack */
    int pop() {
        if (s.isEmpty()) {
            return -1;
        }
        if (s.peek() < minEle) {
            // If this is true then we have a custom value in the stack
            int temp = minEle; // This is the actual value
            minEle = 2 * temp - s.peek();
            s.pop();
            return temp;
        } else {
            return s.pop();
        }
    }

    /* push element x into the stack */
    void push(int x) {
        if (s.isEmpty()) {
            minEle = x;
            s.add(x);
        } else {
            if (x >= minEle) {
                s.add(x);
            } else {
                s.add(2 * x - minEle);
                minEle = x;
            }
        }
    }
}
