package _238_product_of_array_except_self;

public class SolutionB {
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
