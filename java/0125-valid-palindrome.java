package java;

/**
 * <pre>
 * 
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
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
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        } else {
            s = s.toLowerCase();
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
