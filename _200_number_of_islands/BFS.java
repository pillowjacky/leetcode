package _200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] offset = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                grid[i][j] = '0';
                queue.offer(new int[] {i, j});
                while (!queue.isEmpty()) {
                    int[] vertex = queue.poll();
                    for (int k = 0; k < offset.length; k++) {
                        int oi = vertex[0] + offset[k][0];
                        int oj = vertex[1] + offset[k][1];
                        if (oi < 0 || oi >= grid.length) {
                            continue;
                        }
                        if (oj < 0 || oj >= grid[0].length) {
                            continue;
                        }
                        if (grid[oi][oj] == '0') {
                            continue;
                        }
                        grid[oi][oj] = '0';
                        queue.offer(new int[] {oi, oj});
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
