package striver_og.stacks_and_queues_ii;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/
public class _6_ImplementMinStack {
    int minEle;
    Stack<Integer> s = new Stack<>();

    // 2x - minEle < x

    /* returns min element from stack */
    int getMin() {
        if (s.isEmpty()) {
            return -1;
        } else {
            return minEle;
        }
    }

    /* returns poped element from stack */
    int pop() {
        if (s.isEmpty()) {
            return -1;
        }

        if (s.peek() < minEle) {
            // That means that we need to calculate the element
            // Also need to change up minEle
            int toreturn = minEle;
            minEle = (2 * minEle) - s.pop();
            return toreturn;
        } else {
            return s.pop();
        }

    }

    /* push element x into the stack */
    void push(int x) {
        if (s.isEmpty()) {
            // It is empty so we straightaway add
            s.push(x);
            minEle = x;
        } else {
            if (x >= minEle) {
                s.push(x);
            } else {
                s.push(2 * x - minEle);
                minEle = x;
            }
        }
    }
}
