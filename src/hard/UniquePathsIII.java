package hard;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int startR = -1;
        int startC = -1;

        int emptyCells = 0;
        //find the starting position and number of empty cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }

                if (grid[i][j] == 0) {
                    ++emptyCells;
                }
            }
        }

        return helper(grid, startR, startC, emptyCells, -1);
    }

    int helper(int[][] grid, int x, int y, int emptyCells, int walked) {
        //boundary cases and obstacles check
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            //increase the counter only after we have traversed
            //all the empty cells
            return walked == emptyCells ? 1 : 0;
        }

        int temp = grid[x][y];

        //mark current cell as an obstacle since it is visited
        grid[x][y] = -1;

        int count = helper(grid, x + 1, y, emptyCells, walked + 1) +
                helper(grid, x - 1, y, emptyCells, walked + 1) +
                helper(grid, x, y + 1, emptyCells, walked + 1) +
                helper(grid, x, y - 1, emptyCells, walked + 1);

        //restore the previous state of the cell
        grid[x][y] = temp;

        return count;
    }
}
