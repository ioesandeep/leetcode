package medium;

import easy.TreeNode;

public class SumRootToLeaf {
    int finalSum;

    public int sumNumbers(TreeNode root) {
        finalSum = 0;
        sumPath(root, 0);
        return finalSum;
    }

    void sumPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum *= 10;
        sum += root.val;

        if (root.left == null && root.right == null) {
            finalSum += sum;
            return;
        }

        sumPath(root.left, sum);
        sumPath(root.right, sum);
    }
}
