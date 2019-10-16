package hard;

import java.util.Arrays;

public class KthSmallestPair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int n = nums.length;
        int high = nums[n - 1] - nums[0];
        while (low < high) {
            int cnt = 0;
            int mid = (high + low) / 2;
            int left = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                cnt += right - left;
            }
            if (cnt >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
