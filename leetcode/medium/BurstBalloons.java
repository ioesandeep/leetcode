package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class BurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Queue<Integer> balloons = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
        }
        int arrows = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (balloons.isEmpty()) {
                arrows++;
                balloons.add(point[1]);
            }
            if (point[0] > balloons.peek()) {
                balloons.poll();
                balloons.add(point[1]);
                ++arrows;
            }
        }
        return arrows;
    }
}
