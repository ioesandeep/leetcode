package medium;

import easy.ListNode;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] num1 = toNumber(l1);
        int[] num2 = toNumber(l2);
        int[] sums = sum(num1, num2);

        if (sums.length == 0) {
            return null;
        }

        ListNode result = null;
        ListNode head = null;

        for (int i = 0; i < sums.length; i++) {
            result = new ListNode(sums[i]);
            if (head == null) {
                head = result;
                continue;
            }

            result.next = head;
            head = result;

        }

        return result;
    }

    int[] sum(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return sum(nums2, nums1);
        }

        int carry = 0;
        int[] summed = new int[nums2.length];

        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            int sum = nums1[i] + nums2[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            summed[j++] = sum;
        }

        for (int i = j; i < nums2.length; i++) {
            int sum = nums2[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            summed[i] = sum;
        }

        if (carry == 0) {
            return summed;
        }

        int[] result = new int[summed.length + 1];
        result[summed.length] = carry;
        for (int i = 0; i < summed.length; i++) {
            result[i] = summed[i];
        }

        return result;
    }

    int[] toNumber(ListNode l1) {
        ListNode n = l1;

        int size = getSize(l1);
        int[] nums = new int[getSize(l1)];
        int i = 0;
        while (n != null) {
            nums[size - 1 - i++] = n.val;
            n = n.next;
        }

        return nums;
    }

    int getSize(ListNode l) {
        ListNode n = l;
        int size = 0;
        while (n != null) {
            ++size;
            n = n.next;
        }
        return size;
    }
}
