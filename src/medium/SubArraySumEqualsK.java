package medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int left = 0, right = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++)
            dp[i] = dp[i - 1] + nums[i];

        map.put(k, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(dp[i]))
                res += map.get(dp[i]);
            map.put(k + dp[i], map.getOrDefault(k + dp[i], 0) + 1);
        }
        return res;
    }
}
