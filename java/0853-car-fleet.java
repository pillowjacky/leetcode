package java;

import java.util.Arrays;

/**
 * <pre>
 * 
 * 853. Car Fleet
 * https://leetcode.com/problems/car-fleet/
 * 
 * </pre>
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
        }
        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));

        int out = 0;
        double car = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][1] > car) {
                car = arr[i][1];
                out++;
            }
        }
        return out;
    }
}
