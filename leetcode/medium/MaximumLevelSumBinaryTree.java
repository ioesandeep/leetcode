package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSumBinaryTree {
    Map<Integer, Integer> map;

    public int maxLevelSum(TreeNode root) {
        map = new HashMap<>();
        bfs(root, 1);
        int max = Integer.MIN_VALUE;
        int level = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                level = entry.getKey();
            }
        }
        return level;
    }

    public void bfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        map.put(level, map.getOrDefault(level, 0) + node.val);
        bfs(node.left, level + 1);
        bfs(node.right, level + 1);
    }
}
