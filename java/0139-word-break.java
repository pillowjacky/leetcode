package java;

import java.util.List;

/**
 * <pre>
 * 
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DP (Bottom Up)
 * 
 * </pre>
 */
class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[sLen] = true;
        for (int i = sLen - 1; i >= 0; i--) {
            for (String w : wordDict) {
                int wLen = w.length();
                if (i + wLen <= sLen && s.substring(i, i + wLen).equals(w)) {
                    dp[i] = dp[i + wLen];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}


/**
 * <pre>
 * 
 * DP (Top Down)
 * 
 * </pre>
 */
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dp = new boolean[sLen + 1];
        dp[0] = true;
        for (int i = 1; i <= sLen; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[sLen];
    }
}


/**
 * <pre>
 * 
 * Trie
 * 
 * </pre>
 */
class Solution3 {
    private class Trie {
        private class Node {
            Node[] nodes;
            boolean isWord;

            Node() {
                this.nodes = new Node[26];
                this.isWord = false;
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String s) {
            if (s == null) {
                return;
            }
            s = s.toLowerCase();

            Node curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (curr.nodes[c] == null) {
                    curr.nodes[c] = new Node();
                }
                curr = curr.nodes[c];
            }
            curr.isWord = true;
        }

        public boolean search(String s) {
            if (s == null) {
                return false;
            }
            s = s.toLowerCase();

            Node curr = this.root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (curr.nodes[c] == null) {
                    return false;
                }
                curr = curr.nodes[c];
            }
            return curr.isWord;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String w : wordDict) {
            trie.insert(w);
        }
        return helper(s, trie);
    }

    public boolean helper(String s, Trie trie) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; i++) {
            if (!trie.search(s.substring(0, i))) {
                continue;
            }
            if (!helper(s.substring(i, len), trie)) {
                continue;
            }
            return true;
        }
        return false;
    }
}
