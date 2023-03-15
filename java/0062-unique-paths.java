package java;

/**
 * <pre>
 * 
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DP
 * 
 * </pre>
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == (m - 1) || j == (n - 1)) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
                }
            }
        }
        return arr[0][0];
    }
}
