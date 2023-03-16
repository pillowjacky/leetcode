package java;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Hashing + Backtracking
 * 
 * </pre>
 */
class Solution {
    private static String[][] mapping =
            {{}, {}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
                    {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> out = new ArrayList<>();
        if (!digits.isEmpty()) {
            return out;
        }
        helper(digits, out, 0, "");
        return out;
    }

    private void helper(String digits, List<String> out, int index, String combo) {
        if (index >= digits.length()) {
            out.add(combo);
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(index));
        for (int i = 0; i < mapping[digit].length; i++) {
            helper(digits, out, index + 1, combo + mapping[digit][i]);
        }
    }
}
