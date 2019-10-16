package leetcode.medium;

import leetcode.easy.TreeNode;

import java.util.*;

public class NodesDistanceKBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        if (root == null) {
            return result;
        }
        // get a hashmap with node-->parent
        Map<TreeNode, TreeNode> nodeToParentMap = getNodeToParentMap(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int level = 0;

        while (!queue.isEmpty()) {
            if (level == K) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                }
                TreeNode parent = nodeToParentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                }
            }
            level++;
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }

    private Map<TreeNode, TreeNode> getNodeToParentMap(TreeNode root) {
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        preOrder(root, null, nodeToParentMap);
        return nodeToParentMap;
    }

    private void preOrder(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> nodeToParentMap) {
        if (node == null) return;

        // add it to the map
        nodeToParentMap.put(node, parent);
        //left
        preOrder(node.left, node, nodeToParentMap);
        //right
        preOrder(node.right, node, nodeToParentMap);
    }
}
