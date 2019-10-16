package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FruitInBaskets {
    public int totalFruit(int[] arr) {
        int max = 0;
        int slidePos = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[slidePos], map.get(arr[slidePos]) - 1);
                if (map.get(arr[slidePos]) == 0) {
                    map.remove(arr[slidePos]);
                }
                slidePos++;
            }

            max = Math.max(max, i - slidePos + 1);
        }

        return max;
    }
}
