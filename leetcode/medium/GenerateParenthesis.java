package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> ans = new ArrayList<>();

    public List generateParenthesis(int n) {
        helper(n, 0, "");
        return ans;
    }

    void helper(int n, int q, String str) {
        if (n == 0 && q == 0) {
            ans.add(0, str);
            return;
        }

        if (q != 0) {
            String s1 = str + ')';
            helper(n, q - 1, s1);
        }

        if (n != 0) {
            String s2 = str + '(';
            helper(n - 1, q + 1, s2);
        }
    }
}
