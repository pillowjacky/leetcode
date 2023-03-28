package java;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Backtracking
 * 
 * </pre>
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        helper(n, 0, 0, "", out);
        return out;
    }

    private void helper(int n, int open, int close, String combo, List<String> out) {
        if (open == n && close == n) {
            out.add(combo);
            return;
        }
        if (open < n) {
            helper(n, open + 1, close, combo + "(", out);
        }
        if (close < open) {
            helper(n, open, close + 1, combo + ")", out);
        }
    }
}
