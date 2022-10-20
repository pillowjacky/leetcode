package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * BFS
 * 
 * </pre>
 */
class Solution1 {
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


/**
 * <pre>
 * 
 * DFS
 * 
 * </pre>
 */
class Solution2 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

