package leetcode.medium;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        right[nums.length - 1] = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j];
        }

        output[0] = right[1];
        output[nums.length - 1] = left[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            output[i] = left[i - 1] * right[i + 1];
        }

        return output;
    }
}
