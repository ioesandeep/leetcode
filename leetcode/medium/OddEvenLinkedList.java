package leetcode.medium;

import leetcode.easy.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //lets see how we can optimize it

        ListNode odd = new ListNode(0);
        ListNode oddTail = odd;

        ListNode even = new ListNode(0);
        ListNode evenTail = even;

        ListNode oddCursor = head;
        ListNode evenCursor = head.next;

        while (oddCursor != null && oddCursor.next != null) {
            oddTail.next = new ListNode(oddCursor.val);
            oddTail = oddTail.next;
            oddCursor = oddCursor.next.next;
        }

        if (oddCursor != null) {
            oddTail.next = new ListNode(oddCursor.val);
            oddTail = oddTail.next;
        }

        while (evenCursor != null && evenCursor.next != null) {
            evenTail.next = new ListNode(evenCursor.val);
            evenTail = evenTail.next;
            evenCursor = evenCursor.next.next;
        }

        if (evenCursor != null) {
            evenTail.next = new ListNode(evenCursor.val);
            evenTail = evenTail.next;
        }

        oddTail.next = even.next;

        return odd.next;
    }
}
