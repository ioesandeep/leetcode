package leetcode.medium;

public class MaximumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return helper(grid, 0, 0, grid.length - 1, grid[0].length - 1, memo);
    }

    int helper(int[][] grid, int x, int y, int m, int n, int[][] memo) {
        if (x > m || y > n) {
            return Integer.MAX_VALUE;
        }

        if (x == m && y == n) {
            return grid[x][y];
        }

        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        memo[x][y] = grid[x][y] + Math.min(helper(grid, x, y + 1, m, n, memo), helper(grid, x + 1, y, m, n, memo));
        return memo[x][y];
    }
}
