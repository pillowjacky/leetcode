package java;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <pre>
 * 
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Heap
 * 
 * </pre>
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.put(task, counts.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(counts.values());

        Deque<Integer> queue = new ArrayDeque<>();
        int out = 0;
        while (!maxHeap.isEmpty()) {
            int time = n + 1;
            while (time > 0 && !maxHeap.isEmpty()) {
                queue.offerLast(maxHeap.poll());
                time--;
                out++;
            }
            while (!queue.isEmpty()) {
                int count = queue.pollFirst() - 1;
                if (count > 0) {
                    maxHeap.offer(count);
                }
            }
            if (!maxHeap.isEmpty()) {
                out += time;
            }
        }
        return out;
    }
}
