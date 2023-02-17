package java;

/**
 * <pre>
 * 
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
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
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e : nums) {
            sum += e;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                int e = nums[i - 1];
                if (j < e) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - e];
                }
            }
        }
        return dp[len][sum];
    }
}
