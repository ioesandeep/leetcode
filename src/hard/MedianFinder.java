package hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>((a, b) -> b - a);
        min = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        max.offer(num);

        if (max.size() > min.size() + 1) {
            min.offer(max.poll());
        }

        if (min.size() > 0 && min.peek() < max.peek()) {
            int a = max.poll();
            max.offer(min.poll());
            min.offer(a);
        }
    }

    public double findMedian() {
        int size = min.size() + max.size();
        if (size % 2 == 1) {
            return (double) max.peek();
        }

        return ((double) (max.peek() + min.peek())) / 2;
    }
}
