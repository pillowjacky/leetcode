package java;

/**
 * <pre>
 * 
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
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
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[m] == nums[l] && nums[m] == nums[r]) {
                l++;
                r--;
            } else if (nums[m] >= nums[l]) {
                if (target < nums[m] && target >= nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}
