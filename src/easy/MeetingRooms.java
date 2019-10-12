package easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }
        int[] current = queue.poll();
        while (!queue.isEmpty()) {
            int[] inQueue = queue.poll();
            if (inQueue[0] < current[1]) {
                return false;
            }
            current = inQueue;
        }

        return true;
    }
}
