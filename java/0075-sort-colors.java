package java;

/**
 * <pre>
 * 
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Dutch National Flag Problem
 * 
 * </pre>
 */
class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                i++;
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
