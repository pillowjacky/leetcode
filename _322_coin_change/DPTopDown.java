package _322_coin_change;

public class DPTopDown {
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
