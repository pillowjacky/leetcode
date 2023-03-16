package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
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
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> out = new ArrayList<>();
        if (p.length() > s.length()) {
            return out;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            out.add(0);
        }
        for (int l = 0, r = p.length(); r < s.length(); l++, r++) {
            sCount[s.charAt(r) - 'a']++;
            sCount[s.charAt(l) - 'a']--;
            if (Arrays.equals(sCount, pCount)) {
                out.add(l + 1);
            }
        }
        return out;
    }
}
