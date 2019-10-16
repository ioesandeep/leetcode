package leetcode.medium;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch != ']') {
                stack.push(ch.toString());
                continue;
            }

            StringBuilder str = new StringBuilder();
            StringBuilder counter = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("[")) {
                str.append(stack.pop());
            }

            stack.pop();
            while (!stack.isEmpty() && isNumeric(stack.peek())) {
                counter.append(stack.pop());
            }

            int count = Integer.valueOf(counter.reverse().toString());

            String repeated = repeat(str.toString(), count);
            stack.push(repeated);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    String repeat(String str, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= times; i++) {
            builder.append(str);
        }
        return builder.toString();
    }

    boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
