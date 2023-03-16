package java;

/**
 * <pre>
 * 
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Backtracking
 * 
 * </pre>
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] cache = new boolean[row][col];
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (helper(board, word, cache, y, x, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] cache, int y, int x, int i) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[y].length) {
            return false;
        }
        if (cache[y][x] || board[y][x] != word.charAt(i)) {
            return false;
        }
        if (i == word.length() - 1) {
            return true;
        }
        cache[y][x] = true;
        boolean out = helper(board, word, cache, y - 1, x, i + 1)
                || helper(board, word, cache, y + 1, x, i + 1)
                || helper(board, word, cache, y, x - 1, i + 1)
                || helper(board, word, cache, y, x + 1, i + 1);
        cache[y][x] = false;
        return out;
    }
}
