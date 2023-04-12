package java;

/**
 * <pre>
 * 
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Binary Search
 * 
 * </pre>
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int l = 1;
        int r = max;
        while (l <= r) {
            int m = (l + r) / 2;
            int count = 0;
            for (int pile : piles) {
                count += Math.ceil(pile * 1.0 / m);
            }
            if (count <= h) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
