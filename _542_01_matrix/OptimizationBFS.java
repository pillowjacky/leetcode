package _542_01_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class OptimizationBFS {
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
