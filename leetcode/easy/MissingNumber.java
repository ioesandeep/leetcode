package leetcode.easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int expected = n * (n + 1) / 2 - n;
        int actual = 0;
        for (int i = 0; i < n - 1; i++) {
            actual += nums[i];
        }

        return expected - actual;
    }
}
