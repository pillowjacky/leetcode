package java;

/**
 * <pre>
 * 
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 * 
 * </pre>
 */

class Solution {
    private class Node {
        private int val;
        private int min;
        private Node prev;

        public Node(int val, int min, Node prev) {
            this.val = val;
            this.min = min;
            this.prev = prev;
        }
    }

    private Node last;

    public void push(int val) {
        if (last == null) {
            last = new Node(val, val, null);
        } else {
            last = new Node(val, Math.min(val, last.min), last);
        }
    }

    public void pop() {
        last = last.prev;
    }

    public int top() {
        return last.val;
    }

    public int getMin() {
        return last.min;
    }
}
