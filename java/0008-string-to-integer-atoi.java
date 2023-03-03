package java;

/**
 * <pre>
 * 
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * </pre>
 */

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        boolean negative = false;
        int out = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            negative = s.charAt(i) == '-';
            i++;
        }
        while (i < s.length()) {
            int digit = s.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < out
                    || (Integer.MAX_VALUE / 10 == out && Integer.MAX_VALUE % 10 < digit)) {
                return (negative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            out = out * 10 + digit;
            i++;
        }
        return (negative) ? out * -1 : out;
    }
}
