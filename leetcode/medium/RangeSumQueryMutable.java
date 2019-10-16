package leetcode.medium;

public class RangeSumQueryMutable {
    int[] nums;
    int[] dp;
    public RangeSumQueryMutable(int[] nums) {
        dp = new int[nums.length+1];
        this.nums = new int[nums.length];
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            this.nums[i] = nums[i];
            dp[i+1] = dp[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        int num = nums[i];
        nums[i] = val;
        for (int j = i + 1; j < dp.length; j ++) {
            dp[j] += (val - num);
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}
