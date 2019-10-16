package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        dfs(s, 0, left, right, set, "");
        return new ArrayList<>(set);
    }

    void dfs(String s, int id, int left, int right, Set<String> set, String p) {
        if (id == s.length()) {
            if (left == 0 && right == 0) {
                if (isValid(p)) {
                    set.add(p);
                }
            }
            return;
        }

        if (s.charAt(id) == '(' && left > 0) {
            dfs(s, id + 1, left - 1, right, set, p);
        } else if (s.charAt(id) == ')' && right > 0) {
            dfs(s, id + 1, left, right - 1, set, p);
        }

        dfs(s, id + 1, left, right, set, p + s.charAt(id));
    }

    boolean isValid(String p) {
        int left = 0;
        int right = 0;
        for (char ch : p.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left == 0 && right == 0;
    }
}
