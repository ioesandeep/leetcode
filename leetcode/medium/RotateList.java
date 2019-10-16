package leetcode.medium;

import leetcode.easy.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int size = size(head);
        if (k <= 0 || size <= 1 || k % size == 0) {
            return head;
        }

        ListNode slider = head;
        ListNode slider2 = head;
        for (int i = 1; i <= k % size + 1; i++) {
            slider = slider.next;
        }

        while (slider != null) {
            slider = slider.next;
            slider2 = slider2.next;
        }

        ListNode runner = slider2;

        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (runner.next != null) {
            tail.next = runner.next;
            tail = tail.next;
            runner = runner.next;
        }

        slider2.next = null;
        tail.next = head;

        return result.next;
    }

    int size(ListNode list) {
        int size = 0;
        while (list != null) {
            ++size;
            list = list.next;
        }
        return size;
    }
}
