package stacksandqueues_striver_i;

import java.util.Stack;

class MyQueue {
    // We can have a solution where push is O(N) with 2 stacks
    // When inputed pop everything to push to another stack.
    // After pushing to stack, pop everything from temp stack back into main

    // A better approach would be as follows to make push O(1)

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        // We directly push onto the input stack
        input.push(x);
    }

    public int pop() {
        // If the stack is empty we pop everything from input into output
        // Popping from output gives us the first added node
        // We only pop from input when output is empty
        // Otherwise even if there are new values we just let it sit in input
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        if (input.isEmpty() && output.isEmpty())
            return true;
        return false;
    }
}

public class _4_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        System.out.println("See queue class");
    }
}
