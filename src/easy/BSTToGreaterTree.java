package easy;

public class BSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        bstHelper(root, 0);
        return root;
    }

    int bstHelper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum = bstHelper(root.right, sum);
        root.val += sum;
        sum = bstHelper(root.left, root.val);

        return sum;
    }
}
