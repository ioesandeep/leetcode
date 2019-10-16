package leetcode.medium;

import leetcode.easy.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        int size = getSize(head);
        return sortHelper(head, size);
    }

    public ListNode sortHelper(ListNode head, int size) {
        if (size <= 1) {
            return head;
        }

        ListNode[] partition = partition(head, size);
        partition[0] = sortHelper(partition[0], size / 2);
        partition[1] = sortHelper(partition[1], size - size / 2);
        ListNode sorted = merge(partition[0], partition[1]);
        return sorted;
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode tail = null;
        while (left != null || right != null) {
            int val = Integer.MIN_VALUE;
            if (left == null) {
                val = right.val;
                right = right.next;
            } else if (right == null) {
                val = left.val;
                left = left.next;
            } else if (left.val < right.val) {
                val = left.val;
                left = left.next;
            } else {
                val = right.val;
                right = right.next;
            }
            if (val == Integer.MIN_VALUE) {
                break;
            }
            ListNode n = new ListNode(val);
            if (head == null) {
                head = n;
                tail = head;
            } else {
                tail.next = n;
                tail = tail.next;
            }
        }
        return head;
    }

    ListNode[] partition(ListNode head, int size) {
        int mid = size / 2;
        ListNode left = null;
        ListNode tail = null;
        ListNode right = head;
        for (int i = 1; i <= mid; i++) {
            if (left == null) {
                left = new ListNode(right.val);
                tail = left;
            } else {
                tail.next = new ListNode(right.val);
                tail = tail.next;
            }
            right = right.next;
        }

        ListNode[] res = {left, right};
        return res;
    }

    public int getSize(ListNode head) {
        ListNode n = head;
        int size = 0;
        while (n != null) {
            n = n.next;
            ++size;
        }
        return size;
    }
}
