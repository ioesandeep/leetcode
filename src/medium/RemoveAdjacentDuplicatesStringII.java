package medium;

import java.util.Stack;

public class RemoveAdjacentDuplicatesStringII {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (stack.isEmpty()) {
                stack.push(new int[]{ch, 1});
                continue;
            }

            int[] data = stack.peek();
            if (data[0] == ch && data[1] == k - 1) {
                while (!stack.isEmpty() && stack.peek()[0] == ch) {
                    stack.pop();
                }
            } else if (data[0] == ch) {
                stack.push(new int[]{ch, data[1] + 1});
            } else {
                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder builder = new StringBuilder();
        while (stack.size() > 0) {
            builder.append((char) (stack.pop()[0] + 'a'));
        }

        return builder.reverse().toString();
    }
}
