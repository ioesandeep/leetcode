package leetcode.medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word.toCharArray(), 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int r, int c, char[] chars, int idx) {
        if (idx >= chars.length) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != chars[idx]) {
            return false;
        }

        board[r][c] = ' ';
        boolean ret = dfs(board, r + 1, c, chars, idx + 1) ||
                dfs(board, r - 1, c, chars, idx + 1) ||
                dfs(board, r, c + 1, chars, idx + 1) ||
                dfs(board, r, c - 1, chars, idx + 1);

        board[r][c] = chars[idx];
        return ret;
    }
}
