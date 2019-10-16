package leetcode.hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        while (left < height.length && height[left] == 0) {
            ++left;
        }

        while (right > 0 && height[right] == 0) {
            --right;
        }

        return helper(height, left, right, 0);
    }

    int helper(int[] height, int left, int right, int sum) {
        if (right - left <= 1) {
            return sum;
        }

        if (height[left] < height[right]) {
            int pos = 1;
            int updatedSum = sum;
            while ((left + pos) < right && height[left + pos] < height[left]) {
                updatedSum += (height[left] - height[left + pos]);
                ++pos;
            }
            return helper(height, left + pos, right, updatedSum);
        }

        int pos = 1;
        int updatedSum = sum;
        while ((right - pos) > left && height[right - pos] < height[right]) {
            updatedSum += (height[right] - height[right - pos]);
            ++pos;
        }
        return helper(height, left, right - pos, updatedSum);
    }
}
