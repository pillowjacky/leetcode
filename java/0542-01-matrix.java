package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Brute Force
 * 
 * </pre>
 */
class Solution1 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) {
            return mat;
        }
        int cols = mat[0].length;

        int[][] out = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    out[i][j] = 0;
                } else {
                    for (int k = 0; k < rows; k++) {
                        for (int l = 0; l < cols; l++) {
                            if (mat[k][l] == 0) {
                                int dist = Math.abs(k - i) + Math.abs(l - j);
                                if (out[i][j] == 0) {
                                    out[i][j] = dist;
                                } else {
                                    out[i][j] = Math.min(out[i][j], dist);
                                }
                            }
                        }
                    }
                }
            }
        }
        return out;
    }
}


/**
 * <pre>
 * 
 * DFS (Time Limit Exceeded)
 * 
 * <pre>
 */
class Solution2 {
    private int rows;
    private int cols;
    private int size;

    public int[][] updateMatrix(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        size = rows * cols;

        int[][] out = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] > 0) {
                    out[i][j] = dfs(mat, i, j, new boolean[rows][cols]);
                }
            }
        }
        return out;
    }

    private int dfs(int[][] mat, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) {
            return size;
        }
        if (mat[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;
        int a = Math.min(dfs(mat, i - 1, j, visited), dfs(mat, i + 1, j, visited));
        int b = Math.min(dfs(mat, i, j - 1, visited), dfs(mat, i, j + 1, visited));
        int out = 1 + Math.min(a, b);
        visited[i][j] = false;
        return out;
    }
}


/**
 * <pre>
 * 
 * BFS
 * 
 * </pre>
 */
class Solution3 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] offset = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int i = 0; i < offset.length; i++) {
                int oi = cell[0] + offset[i][0];
                int oj = cell[1] + offset[i][1];
                if (oi >= 0 && oi < rows && oj >= 0 && oj < cols && mat[oi][oj] == -1) {
                    mat[oi][oj] = mat[cell[0]][cell[1]] + 1;
                    q.offer(new int[] {oi, oj});
                }
            }
        }

        return mat;
    }
}


/**
 * <pre>
 * 
 * DP
 * 
 * </pre>
 */
class Solution4 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int size = rows * cols;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    int t = (i - 1 >= 0) ? mat[i - 1][j] : size;
                    int l = (j - 1 >= 0) ? mat[i][j - 1] : size;
                    mat[i][j] = 1 + Math.min(t, l);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int b = (i + 1 < rows) ? mat[i + 1][j] : size;
                    int r = (j + 1 < cols) ? mat[i][j + 1] : size;
                    mat[i][j] = Math.min(mat[i][j], (1 + Math.min(b, r)));
                }
            }
        }

        return mat;
    }
}
