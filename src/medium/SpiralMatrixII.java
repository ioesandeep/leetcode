package medium;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int r1 = 0;
        int r2 = n - 1;
        int c1 = 0;
        int c2 = n - 1;
        int counter = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                matrix[r1][i] = counter++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                matrix[i][c2] = counter++;
            }
            for (int i = c2 - 1; i >= c1; i--) {
                matrix[r2][i] = counter++;
            }
            for (int i = r2 - 1; i > r1; i--) {
                matrix[i][c1] = counter++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return matrix;
    }
}
