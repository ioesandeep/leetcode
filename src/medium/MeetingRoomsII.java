package medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Queue<Integer> room = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }

        int required = 0;
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (!room.isEmpty() && room.peek() <= interval[0]) {
                room.poll();
            } else {
                required++;
            }
            room.add(interval[1]);
        }

        return required;
    }
}
