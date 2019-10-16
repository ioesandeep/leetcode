package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int id = 0;
        int num = 0;
        while (id < k) {
            num = queue.poll();
            id++;
        }

        return num;
    }
}
