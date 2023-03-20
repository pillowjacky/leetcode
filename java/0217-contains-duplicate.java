package java;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * 
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Hashing
 * 
 * </pre>
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
