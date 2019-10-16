package leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesGolfEvent {
    public int cutOffTree(List<List<Integer>> trees) {
        if (trees.size() == 0 || trees.get(0).size() == 0 || trees.get(0).get(0) == 0) {
            return -1;
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < trees.size(); i++) {
            for (int j = 0; j < trees.get(0).size(); j++) {
                if (trees.get(i).get(j) > 1) {
                    queue.offer(new int[]{i, j, trees.get(i).get(j)});
                }
            }
        }

        int moves = 0;
        int startX = 0;
        int startY = 0;
        while (!queue.isEmpty()) {
            int[] tree = queue.poll();
            int travel = bfs(trees, startX, startY, tree[0], tree[1]);
            if (travel < 0) {
                return -1;
            }
            moves += travel;
            startX = tree[0];
            startY = tree[1];
        }

        return moves;
    }

    int bfs(List<List<Integer>> trees, int r1, int c1, int r2, int c2) {
        int rows = trees.size();
        int cols = trees.get(0).size();
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1, 0});
        visited[r1][c1] = true;
        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == r2 && current[1] == c2) {
                return current[2];
            }

            for (int[] dir : dirs) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];

                if (x >= 0 && y >= 0 && x < rows && y < cols && !visited[x][y] && trees.get(x).get(y) > 1) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y, current[2] + 1});
                }
            }
        }
        return -1;
    }
}
