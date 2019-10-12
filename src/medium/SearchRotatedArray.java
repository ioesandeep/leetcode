package medium;

public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        //binary search
        //average runtime O(logn)
        //worst case O(n)
        if (nums.length == 0) {
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] < nums[mid]) {
            //left side order is correct
            if (target < nums[mid] && target >= nums[start]) {
                return search(nums, target, start, mid - 1);
            }
            return search(nums, target, mid + 1, end);
        } else if (nums[mid] < nums[start]) {
            //right side order is correct
            if (target > nums[mid] && target <= nums[end]) {
                return search(nums, target, mid + 1, end);
            }
            return search(nums, target, start, mid - 1);
        } else if (nums[mid] == nums[start]) {
            //left or right is repeated
            //if right is different than mid
            //search on the right side
            if (nums[mid] != nums[end]) {
                return search(nums, target, mid + 1, end);
            }
            //if right is not different
            //search on the left side
            int res = search(nums, target, start, mid - 1);
            if (res == -1) {
                //if not found on left side
                //search the right side
                return search(nums, target, mid + 1, end);
            }
            //return result from left side search
            return res;
        }
        //the number was not found
        return -1;
    }
}
