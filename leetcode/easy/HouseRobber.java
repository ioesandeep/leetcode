package leetcode.easy;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(helper(nums, 0, dp), helper(nums, 1, dp));
    }

    int helper(int[] nums, int house, int[] dp) {
        if (house >= nums.length) {
            return 0;
        }
        if (dp[house] > -1) {
            return dp[house];
        }
        dp[house] = nums[house] + Math.max(helper(nums, house + 2, dp), helper(nums, house + 3, dp));
        return dp[house];
    }
}
