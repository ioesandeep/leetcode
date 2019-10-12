package hard;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverTreePreOrder {
    //a temp class to store node value and level
    class Node {
        int val;
        int level;

        Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    public TreeNode recoverFromPreorder(String str) {
        int level = 0;
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                ++level;
                continue;
            }

            //find the node value
            StringBuilder builder = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c != '-') {
                    builder.append(c);
                    continue;
                }
                break;
            }
            //found a node, add it to list
            Node n = new Node(Integer.valueOf(builder.toString()), level);
            nodes.add(n);

            //reset the level
            level = 0;
        }
        //since we have list of nodes and their corresponding level
        //lets start building the tree
        return buildTree(nodes, 0, 0, 0, nodes.size());
    }

    TreeNode buildTree(List<Node> nodes, int pos, int level, int minPos, int maxPos) {
        if (minPos > maxPos) {
            return null;
        }

        TreeNode node = new TreeNode(nodes.get(pos).val);

        //find left and right nodes position in list
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = minPos; i < maxPos; i++) {
            Node n = nodes.get(i);
            if (n.level == level + 1) {
                if (left == Integer.MIN_VALUE) {
                    left = i;
                } else {
                    right = i;
                }
            }

            if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE) {
                break;
            }
        }

        Node leftNode = left != Integer.MIN_VALUE ? nodes.get(left) : null;
        Node rightNode = right != Integer.MIN_VALUE ? nodes.get(right) : null;

        if (leftNode == null) {
            //no left child, no point going further
            return node;
        }

        node.left = buildTree(nodes, left, level + 1, left, rightNode == null ? maxPos : right);

        if (rightNode != null) {
            node.right = buildTree(nodes, right, level + 1, right, maxPos);
        }
        return node;
    }
}
