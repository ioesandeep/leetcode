package easy;

public class RangeSumOfBST {
    private int sum;

    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        bstHelper(root, L, R);
        return sum;
    }

    private void bstHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= min && root.val <= max) {
            sum += root.val;
        }

        bstHelper(root.left, min, max);
        bstHelper(root.right, min, max);
    }
}
