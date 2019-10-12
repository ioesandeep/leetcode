package medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    Set<String> area = new HashSet<>();

    public int numDistinctIslands(int[][] grid) {
        int islands = 0;
        int id = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, i, j, builder);
                    if (area.add(builder.toString())) {
                        ++islands;
                    }
                }
            }
        }

        return islands;
    }

    void dfs(int[][] grid, int x, int y, StringBuilder sb) {
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            int[] dir = dirs[i];
            int X = x + dir[0], Y = y + dir[1];
            if (X >= 0 && Y >= 0 && X < m && Y < n && grid[X][Y] == 1) {
                sb.append(i);
                dfs(grid, X, Y, sb);
            }
        }
        sb.append('4');
    }

}
