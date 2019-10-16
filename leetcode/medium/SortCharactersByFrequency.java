package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - '0']++;
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> chars[a] == chars[b] ? 1 : (chars[b] - chars[a]));
        for (int i = 0; i <= 255; i++) {
            if (chars[i] == 0) {
                continue;
            }
            queue.add(i);
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            int ch = queue.poll();
            StringBuilder repeat = new StringBuilder();
            char c = (char) ch;
            for (int i = 1; i <= chars[ch]; i++) {
                repeat.append(c);
            }
            builder.append(repeat.toString());
        }

        return builder.toString();
    }
}
