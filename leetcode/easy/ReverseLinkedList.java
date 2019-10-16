package leetcode.easy;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode copy = head;

        while (head.next != null) {
            ;
            ListNode next = head.next;
            head.next = next.next;
            next.next = prev == null ? head : prev;
            prev = next;
            copy = next;
        }

        return copy;
    }
}
