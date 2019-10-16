package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeCompletenessCheck {
    Map<Integer, List<Integer>> map;
    int maxLevel = Integer.MIN_VALUE;

    public boolean isCompleteTree(TreeNode root) {
        //lets try dfs
        map = new HashMap<>();
        dfs(root, 0);

        //can be optimized
        for (Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
            int level = m.getKey();
            List<Integer> nodes = m.getValue();

            if (level < maxLevel) {
                int req = (int) Math.pow(2, level);
                int count = 0;
                for (Integer i : nodes) {
                    if (i != Integer.MIN_VALUE) {
                        ++count;
                    }
                }

                if (req != count) {
                    return false;
                }
            }

            int end = -1;
            for (int i = nodes.size() - 1; i >= 0; i--) {
                if (nodes.get(i) != Integer.MIN_VALUE) {
                    end = i;
                    break;
                }
            }

            for (int i = 0; i <= end; i++) {
                if (nodes.get(i) == Integer.MIN_VALUE) {
                    return false;
                }
            }
        }
        return true;
    }

    void dfs(TreeNode root, int level) {

        if (map.size() == level) {
            map.put(level, new ArrayList<>());
        }

        if (root == null) {
            map.get(level).add(Integer.MIN_VALUE);
            return;
        }

        if (level > maxLevel) {
            maxLevel = level;
        }

        map.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
