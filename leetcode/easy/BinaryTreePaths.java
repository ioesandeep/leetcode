package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        String str = "";
        result = new ArrayList<>();
        treePathsHelper(root, str);
        return result;
    }

    void treePathsHelper(TreeNode root, String path) {
        //base cases
        //case I
        if (root == null) {
            return;
        }
        //case II
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }

        if (root.left != null) {
            treePathsHelper(root.left, path + root.val + "->");
        }

        if (root.right != null) {
            treePathsHelper(root.right, path + root.val + "->");
        }
    }
}
