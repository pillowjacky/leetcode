package _3_longest_substring_without_repeating_characters;

public class OptimizationSlidingWindow {
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
