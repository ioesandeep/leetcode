package easy;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        boolean[][] filled = new boolean[image.length][image[0].length];
        fillHelper(image, sr, sc, oldColor, newColor, filled);
        return image;
    }

    void fillHelper(int[][] image, int r, int c, int oldC, int newC, boolean[][] filled) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldC || filled[r][c]) {
            return;
        }

        image[r][c] = newC;
        filled[r][c] = true;
        fillHelper(image, r - 1, c, oldC, newC, filled);
        fillHelper(image, r + 1, c, oldC, newC, filled);
        fillHelper(image, r, c - 1, oldC, newC, filled);
        fillHelper(image, r, c + 1, oldC, newC, filled);
    }
}
