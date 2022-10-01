package java;

/**
 * <pre>
 * 
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DP (Bottom Up)
 * 
 * </pre>
 */
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] cache = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i >= c && cache[i - c] != -1) {
                    min = Math.min(min, cache[i - c] + 1);
                }
            }
            cache[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return cache[amount];
    }
}


/**
 * <pre>
 * 
 * DP (Top Down)
 * 
 * </pre>
 */
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return calculate(coins, amount, new int[amount + 1]);
    }

    private int calculate(int[] coins, int rem, int[] cache) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (cache[rem] != 0) {
            return cache[rem];
        }
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int r = calculate(coins, rem - c, cache);
            if (r != -1) {
                min = Math.min(min, r + 1);
            }
        }
        cache[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return cache[rem];
    }
}
