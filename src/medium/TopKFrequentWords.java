package medium;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> sorter = new PriorityQueue<>((p1, p2) -> {
            if (map.get(p1) == map.get(p2)) {
                return p1.compareToIgnoreCase(p2);
            }
            return map.get(p2) - map.get(p1);
        });

        for (String entry : map.keySet()) {
            sorter.add(entry);
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            if (sorter.size() > 0) {
                result.add(sorter.remove());
            }
        }

        return result;
    }
}
