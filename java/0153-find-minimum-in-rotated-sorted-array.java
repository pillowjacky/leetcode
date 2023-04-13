package java;

/**
 * <pre>
 * 
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
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
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[r] > nums[l]) {
                break;
            }
            int m = (l + r) / 2;
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}
