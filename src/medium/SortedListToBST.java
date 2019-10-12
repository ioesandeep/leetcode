package medium;

import easy.ListNode;
import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        //simplest approach is to convert the list to array
        //and then create a minimal bst
        if (head == null) {
            return null;
        }

        int[] arr = toArray(head);
        return createBST(arr, 0, arr.length - 1);
    }

    TreeNode createBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createBST(arr, start, mid - 1);
        node.right = createBST(arr, mid + 1, end);

        return node;
    }

    int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer num : list) {
            res[i++] = num;
        }

        return res;
    }
}
