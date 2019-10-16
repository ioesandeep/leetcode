package easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j++;
            }
        }
    }
}
