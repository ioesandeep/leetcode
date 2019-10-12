package hard;

import easy.TreeNode;

public class BinaryTreeMaxPathSum {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        maxSum = Math.max(left + right + root.val, maxSum);

        return Math.max(left, right) + root.val;
    }
}
