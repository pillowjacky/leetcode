package java;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * </pre>
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int y = matrix.length;
        if (y == 0) {
            return null;
        }
        int x = matrix[0].length;
        if (x == 0) {
            return null;
        }
        int size = y * x;

        List<Integer> out = new ArrayList<>();
        int top = 0;
        int bottom = y - 1;
        int left = 0;
        int right = x - 1;
        while (out.size() < size) {
            for (int i = left; out.size() < size && i <= right; i++) {
                out.add(matrix[top][i]);
            }
            top++;
            for (int i = top; out.size() < size && i <= bottom; i++) {
                out.add(matrix[i][right]);
            }
            right--;
            for (int i = right; out.size() < size && i >= left; i--) {
                out.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; out.size() < size && i >= top; i--) {
                out.add(matrix[i][left]);
            }
            left++;
        }
        return out;
    }
}
