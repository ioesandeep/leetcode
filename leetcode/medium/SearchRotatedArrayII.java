package leetcode.medium;

public class SearchRotatedArrayII {
    public boolean search(int[] nums, int target) {
        //binary search
        //same as finding index of target in rotated array
        //instead of returning index we need to return
        //if the target exists in the array
        if (nums.length == 0) {
            return false;
        }

        return search(nums, target, 0, nums.length - 1);
    }

    public boolean search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[left] < nums[mid]) {
            if (target < nums[mid] && target >= nums[left]) {
                return search(nums, target, left, mid - 1);
            }
            return search(nums, target, mid + 1, right);
        } else if (nums[mid] < nums[left]) {
            if (target > nums[mid] && target <= nums[right]) {
                return search(nums, target, mid + 1, right);
            }
            return search(nums, target, left, mid - 1);
        } else if (nums[mid] == nums[left]) {
            if (nums[right] != nums[mid]) {
                return search(nums, target, mid + 1, right);
            }

            boolean res = search(nums, target, left, mid - 1);
            if (!res) {
                return search(nums, target, mid + 1, right);
            }
            return res;
        }

        return false;
    }
}
