package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <pre>
 * 
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
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
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : nums) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
            heap.offer(count);
        }
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = heap.poll().getKey();
        }
        return out;
    }
}


/**
 * <pre>
 * 
 * Bucket Sort
 * 
 * </pre>
 */
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            bucket.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
            bucket.get(count.getValue() - 1).add(count.getKey());
        }
        int[] out = new int[k];
        for (int i = bucket.size() - 1; i >= 0; i--) {
            List<Integer> list = bucket.get(i);
            for (Integer num : list) {
                out[--k] = num;
                if (k == 0) {
                    return out;
                }
            }
        }
        return out;
    }
}
