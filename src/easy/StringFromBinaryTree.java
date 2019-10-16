package easy;

public class StringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String output = String.valueOf(t.val);
        if (t.left != null || t.right != null) {
            output += "(" + tree2str(t.left) + ")";
            if (t.right != null) {
                output += "(" + tree2str(t.right) + ")";
            }
        }
        return output;
    }
}
