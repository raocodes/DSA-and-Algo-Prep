package striver_sheet.stacksandqueues_i;

import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }

    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class _3_ImplementStackUsingQueues {
    public static void main(String[] args) {
        System.out.println("See stack class");
    }
}
