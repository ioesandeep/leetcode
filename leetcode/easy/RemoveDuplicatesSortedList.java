package leetcode.easy;

public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode runner = current.next;
            while (runner != null && runner.val == current.val) {
                runner = runner.next;
            }
            current.next = runner;
            current = current.next;
        }
        return head;
    }
}
