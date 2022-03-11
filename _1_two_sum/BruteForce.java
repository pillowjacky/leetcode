package _1_two_sum;

class BruteForce {
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
