package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Hashing
 * 
 * </pre>
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] counts = new char[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            String key = new String(counts);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
