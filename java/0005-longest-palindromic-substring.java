package java;

/**
 * <pre>
 * 
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Two Pointers
 * 
 * </pre>
 */
class Solution {
    public String longestPalindrome(String s) {
        int sLen = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        String out = null;
        for (int i = 0; i < sLen; i++) {
            left = i;
            right = i;
            while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
                int currLen = right - left + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    out = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < sLen && s.charAt(left) == s.charAt(right)) {
                int currLen = right - left + 1;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    out = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return out;
    }
}
