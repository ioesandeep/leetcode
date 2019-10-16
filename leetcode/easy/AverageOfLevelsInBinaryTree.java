package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    List<List<Integer>> data;

    public List<Double> averageOfLevels(TreeNode root) {
        data = new LinkedList<>();
        dfs(root, 0);
        return result();
    }

    void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == data.size()) {
            data.add(new LinkedList<Integer>());
        }

        data.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    List<Double> result() {
        List<Double> result = new LinkedList<>();
        for (List<Integer> d : data) {
            double sum = 0;
            for (Integer val : d) {
                sum += val;
            }
            result.add(sum / d.size());
        }

        return result;
    }
}
