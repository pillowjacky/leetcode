package java;

import java.util.HashMap;

/**
 * <pre>
 * 
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
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
    public int[] twoSum(int[] nums, int target) {
        var n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}


/**
 * <pre>
 * 
 * Hashing
 * 
 * </pre>
 */
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        var m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var delta = target - nums[i];
            if (m.containsKey(delta)) {
                return new int[] {m.get(delta), i};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
