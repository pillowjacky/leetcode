package java;

/**
 * <pre>
 * 
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Brute Force (Time Limit Exceeded)
 * 
 * </pre>
 */
class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] out = new int[l];
        for (int i = 0; i < l; i++) {
            int n = 1;
            for (int j = 0; j < l; j++) {
                if (i != j) {
                    n *= nums[j];
                }
            }
            out[i] = n;
        }
        return out;
    }
}


/**
 * <pre>
 * 
 * Prefix & Suffix Products
 * 
 * </pre>
 */
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] out = new int[l];
        for (int i = 0, v = 1; i < l; i++) {
            out[i] = v;
            v *= nums[i];
        }
        for (int i = l - 1, v = 1; i >= 0; i--) {
            out[i] *= v;
            v *= nums[i];
        }
        return out;
    }
}
