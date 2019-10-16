package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < words.length; k++) {
                    String word = words[k];
                    if (word.equals("")) {
                        continue;
                    }

                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, i, j, word.toCharArray(), 0)) {
                            result.add(word);
                            words[k] = "";
                        }

                    }
                }
            }
        }
        return result;
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
