package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Two Pointers
 * 
 * </pre>
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    out.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right) {
                        left++;
                        if (nums[left] != nums[left - 1]) {
                            break;
                        }
                    }
                    while (left < right) {
                        right--;
                        if (nums[right] != nums[right + 1]) {
                            break;
                        }
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return out;
    }
}
