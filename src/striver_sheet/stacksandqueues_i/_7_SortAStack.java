package striver_sheet.stacksandqueues_i;

import java.util.Stack;

// https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class _7_SortAStack {
    public static void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insert(stack, element);

        stack.push(temp);
    }

    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    public static void sortStack(Stack<Integer> stack) {
        sort(stack);
    }

}
