package _542_01_matrix;

public class BruteForceDFS {
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
