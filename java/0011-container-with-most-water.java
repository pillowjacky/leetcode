package java;

/**
 * <pre>
 * 
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Brute Force
 * 
 * </pre>
 */
class Solution1 {
    public int maxArea(int[] height) {
        int out = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int amt = (j - i) * Math.min(height[i], height[j]);
                out = Math.max(out, amt);
            }
        }
        return out;
    }
}


/**
 * <pre>
 * 
 * Two Pointers
 * 
 * </pre>
 */
class Solution2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int out = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            out = Math.max(out, (right - left) * Math.min(leftHeight, rightHeight));
            if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return out;
    }
}
