package leetcode.easy;

public class MinimumDistanceBetweenBSTNodes {
    private int min;
    private int prev;

    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;

        inorder(root.right);
    }
}
