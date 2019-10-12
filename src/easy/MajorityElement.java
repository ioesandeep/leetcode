package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;
        for (int num : nums) {
            int c = count.getOrDefault(num, 0) + 1;
            count.put(num, c);
            if (c > maxCount) {
                maxCount = c;
                maxKey = num;
            }
        }

        return maxKey;
    }
}
