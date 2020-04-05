package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReOrderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Queue<String> queue = new PriorityQueue<>(this::compare);
        List<String> digits = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            int id = logs[i].indexOf(" ") + 1;
            if (Character.isDigit(logs[i].charAt(id))) {
                digits.add(logs[i]);
                continue;
            }
            queue.offer(logs[i]);
        }

        String[] result = new String[logs.length];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll();
        }

        for (String log : digits) {
            result[i++] = log;
        }

        return result;
    }

    private int compare(String a, String b) {
        String[] as = a.split(" ");
        String[] bs = b.split(" ");
        for (int i = 1; i < as.length; i++) {
            if (i >= bs.length) {
                return -1;
            }

            String ai = as[i];
            String bi = bs[i];

            if (ai.equals(bi)) {
                continue;
            }

            return ai.compareToIgnoreCase(bi);
        }

        return as[0].compareToIgnoreCase(bs[0]);
    }
}
