package java;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * 78. Subsets
 * https://leetcode.com/problems/subsets/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DFS
 * 
 * </pre>
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, out, tmp, 0);
        return out;
    }

    private void dfs(int[] nums, List<List<Integer>> out, List<Integer> tmp, int i) {
        if (i == nums.length) {
            out.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[i]);
        dfs(nums, out, tmp, i + 1);
        tmp.remove(tmp.size() - 1);
        dfs(nums, out, tmp, i + 1);
    }
}
