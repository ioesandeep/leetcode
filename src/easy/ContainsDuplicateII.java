package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
                continue;
            }

            int diff = Math.abs(map.get(num) - i);
            if (diff <= k) {
                return true;
            }

            map.put(num, i);
        }

        return false;
    }
}
