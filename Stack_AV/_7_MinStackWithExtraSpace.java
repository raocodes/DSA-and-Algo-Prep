package Stack_AV;

import java.util.Stack;

public class _7_MinStackWithExtraSpace {
    Stack<Integer> ss = new Stack<>();

    public void push(int a, Stack<Integer> s) {
        s.add(a);
        if (ss.isEmpty() || ss.peek() >= a) {
            ss.add(a);
        }
    }

    public int pop(Stack<Integer> s) {
        int data = s.pop();
        if (data == ss.peek()) {
            ss.pop();
        }
        return data;
    }

    public int min(Stack<Integer> s) {
        if (ss.isEmpty()){
            return -1;
        } else {
            return ss.peek();
        }
    }

    public boolean isFull(Stack<Integer> s, int n) {
        return s.size() >= n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.isEmpty();
    }
}
