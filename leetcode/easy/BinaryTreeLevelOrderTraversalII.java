package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> result;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new LinkedList<>();

        dfs(root, 0);

        List<List<Integer>> output = new LinkedList<>();
        for (List<Integer> res : result) {
            output.add(0, res);
        }

        return output;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            List<Integer> list = new LinkedList<>();
            result.add(list);
        }

        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
