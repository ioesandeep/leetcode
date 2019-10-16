package medium;

import easy.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

    int countNodes(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        ++count;
        count = countNodes(root.left, count);
        return countNodes(root.right, count);
    }
}
