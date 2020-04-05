package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    class Node {
        List<Node> children;
        int val;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelData = new ArrayList<>(size);

            for (int i = 1; i <= size; i++) {
                Node node = queue.poll();
                levelData.add(node.val);

                if (node.children.size() > 0) {
                    queue.addAll(node.children);
                }
            }

            if (levelData.size() > 0) {
                result.add(levelData);
            }
        }

        return result;
    }
}
