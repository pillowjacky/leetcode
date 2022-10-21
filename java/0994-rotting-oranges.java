package java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
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
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int[][] offsets = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] vertex = queue.poll();
                for (int[] offset : offsets) {
                    int oi = vertex[0] + offset[0];
                    int oj = vertex[1] + offset[1];
                    if (oi < 0 || oi >= grid.length) {
                        continue;
                    }
                    if (oj < 0 || oj >= grid[0].length) {
                        continue;
                    }
                    if (grid[oi][oj] != 1) {
                        continue;
                    }
                    grid[oi][oj] = 2;
                    fresh--;
                    queue.offer(new int[] {oi, oj});
                }
            }
            ans++;
        }
        if (fresh == 0) {
            return ans;
        } else {
            return -1;
        }
    }
}
