package leetcode.hard;

import leetcode.easy.ListNode;

public class MergeKSortedLists {
    //out of the head solution
    //put the elements of all the lists in an array
    //sort the array
    //resconstruct the list from array
    //but this is pretty straight forward
    //the interviewer is not expecting this approach
    //approach2: Find the smallest the list
    //add it to result
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        //get a reference to head
        ListNode tail = result;

        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        mergeHelper(lists, tail);

        return result.next;
    }

    void mergeHelper(ListNode[] lists, ListNode tail) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        //we can optimize it here
        //instead of doing one by one
        //detect batch of min numbers
        //and add them to list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }

            int val = lists[i].val;
            if (val <= min) {
                min = val;
                idx = i;
            }
        }

        if (idx == -1) {
            return;
        }

        lists[idx] = lists[idx].next;
        ListNode node = new ListNode(min);

        tail.next = node;
        tail = tail.next;

        mergeHelper(lists, tail);
    }
}
