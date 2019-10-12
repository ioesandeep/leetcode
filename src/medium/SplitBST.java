package medium;

import easy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode first = null;
        TreeNode second = null;

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node.val <= V) {
                    first = insert(first, node.val);
                } else {
                    second = insert(second, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return new TreeNode[]{first, second};
    }

    TreeNode insert(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
        } else {
            TreeNode insertNode = findInsertNode(root, val);
            if (val > insertNode.val) {
                insertNode.right = node;
            } else {
                insertNode.left = node;
            }
        }
        return root;
    }

    public TreeNode findInsertNode(TreeNode root, int v) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left != null && root.val > v) {
            return findInsertNode(root.left, v);
        }

        if (root.right != null && root.val < v) {
            return findInsertNode(root.right, v);
        }

        return root;
    }
}
