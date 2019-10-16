package leetcode.medium;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty() || !isOppositeDirection(a, stack.peek())) {
                stack.push(a);
                continue;
            }

            int x = 0;
            int y = 0;
            int z = 0;
            int b = a;

            while (!stack.isEmpty() && isOppositeDirection(b, stack.peek())) {
                x = Math.abs(b);
                y = stack.pop();
                z = Math.abs(y);
                if (z > x) {
                    b = y;
                } else if (!stack.isEmpty() && z == x) {
                    b = stack.peek();
                }
            }

            if (x != 0 && z != 0 && x > z) {
                stack.push(a);
            }
            if (x != 0 && z != 0 && z > x) {
                stack.push(y);
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }

    boolean isOppositeDirection(int a, int b) {
        return (a < 0 && b > 0);
    }
}
