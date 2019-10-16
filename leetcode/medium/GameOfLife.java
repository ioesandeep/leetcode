package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String id = "(" + i + "," + j + ")";
                map.put(id, board[i][j]);
            }
        }

        int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbours = 0;
                for (int k = 0; k < dirs.length; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];
                    String id = "(" + x + "," + y + ")";
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && map.get(id) == 1) {
                        ++neighbours;
                    }
                }
                if (board[i][j] == 1) {
                    if (neighbours < 2 || neighbours > 3) {
                        board[i][j] = 0;
                    } else if (neighbours > 1) {
                        board[i][j] = 1;
                    }
                }
                //dead cell becomes alive
                if (board[i][j] == 0 && neighbours == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
