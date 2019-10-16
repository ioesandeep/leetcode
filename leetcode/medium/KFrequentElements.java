package leetcode.medium;

import java.util.*;

public class KFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (Integer key : map.keySet()) {
            queue.offer(key);
        }


        List<Integer> result = new ArrayList<>();
        while (result.size() < k && !queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
