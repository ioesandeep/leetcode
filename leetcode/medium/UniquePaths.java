package leetcode.medium;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return helper(1, 1, m, n, memo);
    }

    public int helper(int start, int end, int m, int n, int[][] memo) {
        if (start > m || end > n) {
            return 0;
        }

        if (start == m && end == n) {
            return 1;
        }

        if (memo[start][end] > -1) {
            return memo[start][end];
        }

        memo[start][end] = helper(start + 1, end, m, n, memo) + helper(start, end + 1, m, n, memo);
        return memo[start][end];
    }
}
