package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));
        for (int i = 0; i < K; i++) {
            queue.add(points[i]);
        }

        for (int i = K; i < points.length; i++) {
            int dist = getDistance(points[i]);
            int dist2 = getDistance(queue.peek());
            if (dist < dist2) {
                queue.poll();
                queue.offer(points[i]);
            }
        }

        int[][] result = new int[queue.size()][2];
        int j = 0;
        while (!queue.isEmpty()) {
            result[j++] = queue.poll();
        }
        return result;
    }

    int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
