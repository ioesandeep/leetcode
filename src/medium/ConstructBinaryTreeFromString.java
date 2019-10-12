package medium;

import easy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromString {
    class Node {
        int val;
        int level;

        Node(int val, int level) {
            this.val = val;
            this.level = level;
        }

        public String toString() {
            return val + " " + level;
        }
    }

    public TreeNode str2tree(String s) {
        List<Node> nodes = new ArrayList<>();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++level;
                continue;
            }
            if (ch == ')') {
                --level;
                continue;
            }

            boolean flag = false;
            String num = "";
            while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
                num += s.charAt(i);
                i++;
                flag = true;
            }

            //i will be incremented again
            if (flag && num != "") {
                i--;
                nodes.add(new Node(Integer.valueOf(num), level));
            }
        }

        return buildTree(nodes, 0, 0, 0, nodes.size());
    }

    TreeNode buildTree(List<Node> nodes, int id, int level, int minId, int maxId) {
        if (minId >= maxId) {
            return null;
        }

        Node node = nodes.get(id);
        TreeNode tree = new TreeNode(node.val);

        int leftId = -1;
        int rightId = -1;

        for (int i = minId; i < maxId; i++) {
            Node n = nodes.get(i);
            if (n.level != level + 1) {
                continue;
            }
            if (leftId == -1) {
                leftId = i;
            } else {
                rightId = i;
            }

            if (leftId > -1 && rightId > -1) {
                break;
            }
        }

        if (leftId == -1) {
            return tree;
        }

        tree.left = buildTree(nodes, leftId, level + 1, minId, rightId > -1 ? rightId : maxId);
        if (rightId > -1) {
            tree.right = buildTree(nodes, rightId, level + 1, rightId, maxId);
        }

        return tree;
    }
}
