package medium;

import easy.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        pruneTree(root.left);
        if (root.left != null && doesNotContainOne(root.left)) {
            root.left = null;
        }
        if (root.right != null && doesNotContainOne(root.right)) {
            root.right = null;
        }
        pruneTree(root.right);
        return root;
    }

    boolean doesNotContainOne(TreeNode root) {
        if (root == null) {
            return true;
        }
        return root.val == 0 && doesNotContainOne(root.left) && doesNotContainOne(root.right);
    }
}
