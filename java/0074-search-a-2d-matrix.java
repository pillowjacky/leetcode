package java;

/**
 * <pre>
 * 
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Binary Search
 * 
 * </pre>
 */
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = (rows * cols) - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / cols][mid % cols] < target) {
                left = mid + 1;
            } else if (matrix[mid / cols][mid % cols] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}


/**
 * <pre>
 * 
 * "Binary Search Tree"
 * 
 * </pre>
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
