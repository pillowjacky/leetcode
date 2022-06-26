package java;

/**
 * <pre>
 * 
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Sliding Window
 * 
 * </pre>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int out = 0;

        int[] repeated = new int[256];
        for (int left = 0, right = 0; right < s.length(); right++) {
            left = Math.max(left, repeated[s.charAt(right)]);
            repeated[s.charAt(right)] = right + 1;
            out = Math.max(out, right - left + 1);
        }

        return out;
    }
}
