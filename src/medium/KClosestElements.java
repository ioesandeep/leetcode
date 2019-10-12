package medium;

import java.util.*;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int K, int X) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int distA = Math.abs(X - a);
            int distB = Math.abs(X - b);
            if (distA == distB) {
                return a - b;
            }
            return distA - distB;
        });

        for (int num : arr) {
            queue.offer(num);
        }

        for (int i = 0; i < K; i++) {
            result.add(queue.poll());
        }

        Collections.sort(result);

        return result;
    }
}
