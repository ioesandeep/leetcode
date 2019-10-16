package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class NextRightPointersII {
    List<List<Node>> nodes;

    public Node connect(Node root) {
        nodes = new LinkedList<>();
        dfs(root, 0);
        for (List<Node> node : nodes) {
            for (int i = 0; i < node.size() - 1; i++) {
                Node n = node.get(i);
                n.next = node.get(i + 1);
            }
            //if previously set
            Node n = node.get(node.size() - 1);
            n.next = null;
        }

        return root;
    }

    void dfs(Node root, int level) {
        if (root == null) {
            return;
        }

        if (nodes.size() == level) {
            nodes.add(new LinkedList<Node>());
        }

        nodes.get(level).add(root);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
