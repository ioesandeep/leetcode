package medium;

import java.util.Arrays;

public class PrisonCells {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14;
        if (N == 0) N = 14;

        int[] temp = new int[cells.length];
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i < cells.length - 1; i++) {
                if (cells[i - 1] == cells[i + 1]) {
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }
            cells = Arrays.copyOf(temp, cells.length);
        }
        return cells;
    }
}
