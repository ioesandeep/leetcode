package leetcode.easy;

public class MaximumSubArray {
    //kadane's algorithm
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int subsetMax = nums[0];
        int largestSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            subsetMax = Math.max(nums[i], subsetMax + nums[i]);
            if (largestSum < subsetMax) {
                largestSum = subsetMax;
            }
        }

        return largestSum;
    }
}
