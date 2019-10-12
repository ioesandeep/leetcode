package medium;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(obstacleGrid, 0, 0, rows - 1, cols - 1, memo);
    }

    int helper(int[][] grid, int x, int y, int row, int col, int[][] memo) {
        if (x > row || y > col || grid[x][y] == 1) {
            return 0;
        }

        if (x == row && y == col) {
            return 1;
        }

        if (memo[x][y] > -1) {
            return memo[x][y];
        }

        memo[x][y] = helper(grid, x + 1, y, row, col, memo) + helper(grid, x, y + 1, row, col, memo);

        return memo[x][y];
    }
}
