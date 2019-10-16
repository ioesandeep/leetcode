package easy;

public class ClosestBSTValue {
    long val;

    public int closestValue(TreeNode root, double target) {
        val = 0;
        double delta = Long.MAX_VALUE;
        dfs(root, target, delta);
        return (int) val;
    }

    void dfs(TreeNode root, double target, double delta) {
        if (root == null) {
            return;
        }

        double gap = Math.abs(root.val - target);
        if (gap <= delta) {
            val = (long) root.val;
            delta = gap;
        }

        dfs(root.left, target, delta);
        dfs(root.right, target, delta);
    }
}
