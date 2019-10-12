package medium;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }

        //for cols
        for (int i = 0; i < A[0].length; i++) {
            if (A[0][i] == 1) {
                helper(A, 0, i);
            }
            if (A[A.length - 1][i] == 1) {
                helper(A, A.length - 1, i);
            }
        }

        //for rows
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                helper(A, i, 0);
            }
            if (A[i][A[0].length - 1] == 1) {
                helper(A, i, A[0].length - 1);
            }
        }

        int inGrid = 0;
        for (int i = 1; i < A.length - 1; i++) {
            for (int j = 1; j < A[0].length - 1; j++) {
                if (A[i][j] == 1) {
                    inGrid++;
                }
            }
        }

        return inGrid;
    }

    //dfs
    void helper(int[][] matrix, int r, int c) {
        if (r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length || matrix[r][c] == 0) {
            return;
        }

        matrix[r][c] = 0;

        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int[] dir : dirs) {
            helper(matrix, r + dir[0], c + dir[1]);
        }
    }
}
