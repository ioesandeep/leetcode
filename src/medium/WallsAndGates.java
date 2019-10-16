package medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    int inf = 2147483647;
    int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == inf) {
                    rooms[i][j] = bfs(rooms, i, j, 0);
                }
            }
        }
    }

    int bfs(int[][] rooms, int r, int c, int steps) {
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, steps});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] data = queue.poll();
                int x = data[0];
                int y = data[1];
                visited[x][y] = true;
                if (rooms[x][y] == 0) {
                    return data[2];
                }

                for (int[] dir : dirs) {
                    int X = x + dir[0];
                    int Y = y + dir[1];
                    if (X >= 0 && Y >= 0 && X < rooms.length && Y < rooms[0].length &&
                            !visited[X][Y] && rooms[X][Y] != -1) {
                        queue.offer(new int[]{X, Y, data[2] + 1});
                    }
                }
            }
        }
        return inf;
    }
}
