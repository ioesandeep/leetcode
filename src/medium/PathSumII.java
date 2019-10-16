package medium;

import easy.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> output;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        output = new LinkedList<>();
        pathSum(root, new LinkedList<Integer>(), 0, sum);
        return output;
    }

    void pathSum(TreeNode root, List<Integer> result, int sum, int target) {
        //base case 1
        if (root == null) {
            return;
        }

        result.add(root.val);

        sum += root.val;
        //base case 2
        if (root.left == null && root.right == null) {
            if (sum == target) {
                output.add(new LinkedList<>(result));
            }
            result.remove(result.size() - 1);
            return;
        }

        if (root.left != null) {
            pathSum(root.left, result, sum, target);
        }

        if (root.right != null) {
            pathSum(root.right, result, sum, target);
        }
        result.remove(result.size() - 1);

    }
}
