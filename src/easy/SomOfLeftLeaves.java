package easy;

public class SomOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, 0);
    }

    int sumOfLeftLeaves(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum = sumOfLeftLeaves(root.left, sum);
        }

        if (root.right != null) {
            sum = sumOfLeftLeaves(root.right, sum);
        }

        return sum;
    }
}
