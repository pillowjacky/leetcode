package _238_product_of_array_except_self;

// Time Limit Exceeded
public class SolutionA {
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
