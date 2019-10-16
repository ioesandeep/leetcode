package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> result = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!result.containsKey(id)) {
                result.put(id, new PriorityQueue<>((a, b) -> b - a));
            }
            result.get(id).add(score);
        }

        int[][] res = new int[result.size()][2];
        for (Map.Entry<Integer, Queue<Integer>> r : result.entrySet()) {
            int id = r.getKey();
            Queue<Integer> q = r.getValue();
            int sum = 0;
            int end = Math.min(5, q.size());
            for (int i = 0; i < end; i++) {
                sum += q.remove();
            }
            res[id - 1][0] = id;
            res[id - 1][1] = sum / 5;
        }

        return res;
    }
}
