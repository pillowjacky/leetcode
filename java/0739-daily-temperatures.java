package java;

/**
 * <pre>
 * 
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Stack
 * 
 * </pre>
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] out = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--];
                out[index] = i - index;
            }
            stack[++top] = i;
        }
        return out;
    }
}
