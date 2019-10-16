package medium;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }

        LinkedList<int[]> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (result.size() == 0) {
                result.add(interval);
                continue;
            }

            int[] current = result.getLast();
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
                result.set(result.size() - 1, current);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
