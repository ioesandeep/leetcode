package medium;

import easy.TreeNode;

public class MaxDiffNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    int helper(TreeNode root, int min, int max) {
        int gap = max - min;
        if (root == null) {
            return gap;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int newMax = Math.max(helper(root.left, min, max), helper(root.right, min, max));

        return Math.max(gap, newMax);
    }
}
