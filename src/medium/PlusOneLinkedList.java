package medium;

import easy.ListNode;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }

        //reverse the list
        ListNode rev = reverse(head);

        //add 1
        int carry = 1;

        ListNode n = null;
        ListNode tail = null;
        while (rev != null) {
            int sum = carry + rev.val;
            carry = sum / 10;
            sum = sum % 10;
            rev = rev.next;

            //add element to beginning of list
            ListNode node = new ListNode(sum);
            n = node;
            n.next = tail;
            tail = n;
        }

        if (carry == 1) {
            //add carry to beginning of list
            ListNode node = new ListNode(carry);
            n = node;
            n.next = tail;
            tail = n;
        }

        return n;
    }

    //reverse a linked list
    ListNode reverse(ListNode node) {
        ListNode reverse = null;
        ListNode head = null;
        while (node != null) {
            head = new ListNode(node.val);
            head.next = reverse;
            reverse = head;
            node = node.next;
        }
        return reverse;
    }
}
