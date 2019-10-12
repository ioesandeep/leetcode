package medium;

import easy.ListNode;

public class RemoveNthFromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slider = head;
        ListNode marker = head;
        ListNode prev = null;

        for (int i = 1; i <= n; i++) {
            slider = slider.next;
        }

        while (slider != null) {
            prev = marker;
            marker = marker.next;
            slider = slider.next;
        }

        if (prev == null) {
            return marker == head ? marker.next : null;
        }

        prev.next = marker.next;
        return head;
    }
}
