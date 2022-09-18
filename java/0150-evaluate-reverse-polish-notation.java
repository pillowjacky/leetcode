package java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <pre>
 * 
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Stack
 * 
 * </pre>
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        int o2;
        int o1;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    s.offerFirst(s.pollFirst() + s.pollFirst());
                    break;
                case "-":
                    o2 = s.pollFirst();
                    o1 = s.pollFirst();
                    s.offerFirst(o1 - o2);
                    break;
                case "*":
                    s.offerFirst(s.pollFirst() * s.pollFirst());
                    break;
                case "/":
                    o2 = s.pollFirst();
                    o1 = s.pollFirst();
                    s.offerFirst(o1 / o2);
                    break;
                default:
                    s.offerFirst(Integer.parseInt(t));
                    break;
            }
        }
        return s.pollFirst();
    }
}
