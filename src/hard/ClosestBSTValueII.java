package hard;

import easy.TreeNode;

import java.util.*;

public class ClosestBSTValueII {
    Map<Integer, Double> map;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        map = new HashMap<>();
        inorder(root, target);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> Double.compare(map.get(a), map.get(b)));
        queue.addAll(map.keySet());
        List<Integer> result = new LinkedList<>();
        while (result.size() < k && !queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    void inorder(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        inorder(root.left, target);
        map.put(root.val, Math.abs(target - root.val));
        inorder(root.right, target);
    }
}
