package _542_01_matrix;

public class BruteForce {
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
