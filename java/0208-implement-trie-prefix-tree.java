package java;

/**
 * <pre>
 * 
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * </pre>
 */

class Trie {

    public class Node {
        private boolean isWord;
        private Node[] children;

        public Node() {
            this.children = new Node[26];
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (n.children[c - 'a'] == null) {
                n.children[c - 'a'] = new Node();
            }
            n = n.children[c - 'a'];
        }
        n.isWord = true;
    }

    public boolean search(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (n.children[c - 'a'] == null) {
                return false;
            }
            n = n.children[c - 'a'];
        }
        return n.isWord;
    }

    public boolean startsWith(String prefix) {
        Node n = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (n.children[c - 'a'] == null) {
                return false;
            }
            n = n.children[c - 'a'];
        }
        return true;
    }
}
