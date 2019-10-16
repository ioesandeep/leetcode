package leetcode.easy;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> first;
    Stack<Integer> second;

    public QueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        first.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (second.isEmpty()) {
            rebuild();
        }
        return second.pop();
    }

    void rebuild() {
        while (first.size() > 0) {
            second.push(first.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (second.isEmpty()) {
            rebuild();
        }
        return second.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return second.isEmpty() && first.isEmpty();
    }
}
