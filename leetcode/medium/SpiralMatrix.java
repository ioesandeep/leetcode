package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }

            for (int i = r1 + 1; i <= r2; i++) {
                result.add(matrix[i][c2]);
            }

            if (r1 == r2 || c1 == c2) {
                //dont need to copy again
                break;
            }
            for (int i = c2 - 1; i >= c1; i--) {
                result.add(matrix[r2][i]);
            }

            for (int i = r2 - 1; i > r1; i--) {
                result.add(matrix[i][c1]);
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return result;
    }
}
