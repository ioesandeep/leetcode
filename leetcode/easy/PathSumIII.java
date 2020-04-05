package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class PathSumIII {
    int num = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return num;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            sumHelper(node, sum);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return num;
    }

    void sumHelper(TreeNode root, int rem) {
        if (root == null) {
            return;
        }

        rem -= root.val;

        if (rem == 0) {
            num++;
        }

        sumHelper(root.left, rem);
        sumHelper(root.right, rem);

    }
}
