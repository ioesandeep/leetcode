package leetcode.easy;

import java.util.*;

public class FindModeBST {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int count = map.getOrDefault(node.val, 0) + 1;
                if (count > maxCount) {
                    maxCount = count;
                }
                map.put(node.val, count);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        int[] ret = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            ret[i++] = num;
        }

        return ret;
    }
}
