package _542_01_matrix;

public class OptimizationDP {
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
