package medium;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rowHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        boolean colHasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //move it to front
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (rowHasZero) {
            Arrays.fill(matrix[0], 0);
        }

        if (colHasZero) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }
    }
}
