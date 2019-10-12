package medium;

import easy.TreeNode;

public class SmallestStringFromLeaf {
    String minPath;

    public String smallestFromLeaf(TreeNode root) {
        minPath = null;
        smallestPath(root, 0, 1, "");
        return minPath;
    }

    void smallestPath(TreeNode root, int sum, int multiplier, String path) {
        if (root == null) {
            return;
        }

        char ch = (char) (97 + root.val);
        path = ch + path;
        sum = root.val * multiplier + sum;

        if (root.left == null && root.right == null) {
            if (minPath == null || minPath.compareToIgnoreCase(path) > 0) {
                minPath = path;
            }
            return;
        }

        multiplier *= 10;

        smallestPath(root.left, sum, multiplier, path);
        smallestPath(root.right, sum, multiplier, path);
    }
}
