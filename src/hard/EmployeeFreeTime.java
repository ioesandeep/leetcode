package hard;

import java.util.*;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Interval> queue = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                queue.add(interval);
            }
        }

        LinkedList<Interval> merged = new LinkedList<>();
        while (!queue.isEmpty()) {
            Interval current = queue.poll();
            if (merged.isEmpty()) {
                merged.add(current);
                continue;
            }

            Interval last = merged.getLast();
            if (current.start <= last.end) {
                last.end = Math.max(last.end, current.end);
                merged.set(merged.size() - 1, last);
            } else {
                merged.add(current);
            }
        }

        List<Interval> result = new ArrayList<>();
        Interval current = merged.removeFirst();
        while (merged.size() > 0) {
            Interval interval = merged.removeFirst();
            result.add(new Interval(current.end, interval.start));
            current = interval;
        }

        return result;
    }
}
