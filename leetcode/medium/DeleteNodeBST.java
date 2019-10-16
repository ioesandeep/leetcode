package leetcode.medium;

import leetcode.easy.TreeNode;

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            root = mergeLeftAndRight(root.left, root.right);
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    TreeNode mergeLeftAndRight(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null ? right : left;
        }

        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;
        return left;
    }
}
