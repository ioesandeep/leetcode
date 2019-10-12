package easy;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.size() == 0) {
            min.push(x);
            return;
        }

        int m = min.peek();
        if (x <= m) {
            min.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if (min.size() == 0) {
            return;
        }

        int m = min.peek();
        if (num <= m) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
