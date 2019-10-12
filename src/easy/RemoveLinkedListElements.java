package easy;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode list = new ListNode(Integer.MIN_VALUE);
        ListNode tail = list;

        while (head != null) {
            if (head.val != val) {
                tail.next = new ListNode(head.val);
                tail = tail.next;
            }
            head = head.next;
        }

        return list.next;
    }
}
