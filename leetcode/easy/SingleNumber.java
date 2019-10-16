package leetcode.easy;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int missing = 0;
        for (int i = 0; i < nums.length; i++) {
            missing ^= nums[i];
        }
        return missing;
    }
}
