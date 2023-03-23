package java;

/**
 * <pre>
 * 
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * "Hashing" (Using array)
 * 
 * </pre>
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = i / 3 + (j / 3 * 3);
                int n = board[i][j] - '1';
                if (row[i][n]++ > 0 || col[j][n]++ > 0 || grid[k][n]++ > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
