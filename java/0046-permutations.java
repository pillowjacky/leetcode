package java;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Recursion
 * 
 * </pre>
 */
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return ans;
    }

    private void permute(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permute(nums, idx + 1);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
