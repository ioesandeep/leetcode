package easy;

public class DiameterOfBinaryTree {
    int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        helper(root);
        return maxDiameter;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int diameter = left + right;
        maxDiameter = Math.max(diameter, maxDiameter);

        return Math.max(left, right) + 1;
    }
}
