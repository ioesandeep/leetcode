package easy;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafBinaryNumbers {
    List<String> paths;

    public int sumRootToLeaf(TreeNode root) {
        paths = new LinkedList<>();
        discoverPaths(root, "");

        int sum = 0;
        for (String path : paths) {
            sum += Integer.valueOf(path, 2);
        }

        return sum;
    }

    private void discoverPaths(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += root.val;

        if (root.left == null && root.right == null) {
            paths.add(path);
        }

        if (root.left != null) {
            discoverPaths(root.left, path);
        }

        if (root.right != null) {
            discoverPaths(root.right, path);
        }
    }
}
