package medium;

import easy.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode tailSm = small;

        ListNode large = new ListNode(0);
        ListNode tailLg = large;

        ListNode slider = head;
        while (slider != null) {
            if (slider.val < x) {
                tailSm.next = new ListNode(slider.val);
                tailSm = tailSm.next;
            } else {
                tailLg.next = new ListNode(slider.val);
                tailLg = tailLg.next;
            }
            slider = slider.next;
        }

        tailSm.next = large.next;

        return small.next;
    }
}
