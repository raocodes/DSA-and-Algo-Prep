package stacksandqueues_striver_i;

class Stack {
    static final int MAX = 1000;
    // We use static final because we want all stack objects to have only this value
    // If we used only final each object's constructor can assign it's value
    int top;
    int[] arr = new int[MAX];

    boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    Stack() {
        top = -1;
    }

    boolean push(int x) {
        if (top == (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            arr[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return arr[top--];
        }
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return arr[top];
        }
    }

    void print() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + "    ");
        }
        System.out.println();
    }
}

// Driver code
public class _1_ImplementStackUsingArrays {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.pop();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("TOS: " + s.peek());
        System.out.print("Elements present in stack: ");
        s.print();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
    }
}
