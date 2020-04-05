package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumAbsoluteDifferenceBST {
    private int min;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            minDiff(root, node);
        }

        return min;
    }

    private void minDiff(TreeNode root, TreeNode current) {
        if (root == null || current == null || root == current) {
            return;
        }

        min = Math.min(min, Math.abs(root.val - current.val));

        minDiff(root.left, current);
        minDiff(root.right, current);
    }
}
