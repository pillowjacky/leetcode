package _322_coin_change;

public class DPBottomUp {
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
