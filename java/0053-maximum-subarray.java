package java;

/**
 * <pre>
 * 
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DP (Kadane’s Algorithm)
 * 
 * </pre>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int out = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            out = Math.max(out, sum);
        }
        return out;
    }
}
