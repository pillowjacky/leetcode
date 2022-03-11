package _1_two_sum;

import java.util.HashMap;

class Optimization {
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
