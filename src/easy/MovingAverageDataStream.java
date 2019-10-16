package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream {
    Queue<Integer> list;
    int capacity;
    int sum;

    public MovingAverageDataStream(int size) {
        list = new LinkedList<>();
        capacity = size;
        sum = 0;
    }

    public double next(int val) {
        int remove = 0;
        if (list.size() == capacity) {
            remove = list.poll();
        }

        sum -= remove;
        sum += val;
        list.add(val);

        return ((double) sum / list.size());
    }
}
