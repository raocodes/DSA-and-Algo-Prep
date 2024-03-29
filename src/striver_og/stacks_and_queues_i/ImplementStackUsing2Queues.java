package striver_og.stacks_and_queues_i;

import java.util.LinkedList;
import java.util.Queue;

class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    // Function to push an element into stack using two queues.
    void push(int a) {
        // Your code here
        q2.add(a);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Function to pop an element from stack using two queues.
    int pop() {
        // Your code here
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.poll();
    }

}

public class ImplementStackUsing2Queues {
    public static void main(String[] args) {
        System.out.println("See queue class");
    }
}
