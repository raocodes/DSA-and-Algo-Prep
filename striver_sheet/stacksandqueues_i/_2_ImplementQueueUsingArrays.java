package striver_sheet.stacksandqueues_i;

class Queue {
    static final int MAX = 1000;
    // We use static final because we want all stack objects to have only this value
    // If we used only final each object's constructor can assign it's value
    int front;
    int rear;
    int[] arr = new int[MAX];

    boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    Queue() {
        front = rear = -1;
    }

    boolean enqueue(int x) {
        if (rear == MAX - 1) {
            System.out.println("Queue is full!");
            return false;
        } else {
            if (front == -1) {
                front++;
            }
            arr[++rear] = x;
            System.out.println(x + " put into the queue");
            return true;
        }
    }

    int dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty!");
            return 0;
        } else {
            return arr[rear--];
        }
    }

    int queueFront() {
        if (front == rear) {
            System.out.println("Queue is empty!");
            return 0;
        } else {
            return arr[rear];
        }
    }

    void print() {
        if (front == rear) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + "    ");
        }
        System.out.println();
    }
}

public class _2_ImplementQueueUsingArrays {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.print();

        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.print();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(20);

        System.out.println("Front of queue: " + q.queueFront());
    }
}
