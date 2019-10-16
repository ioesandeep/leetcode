package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int minDepth = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return minDepth;
    }
}
