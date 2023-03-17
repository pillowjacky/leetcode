package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * 
 * 310. Minimum Height Trees
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Topological Sort + BFS
 * 
 * </pre>
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int adjNode = adj.get(leaf).iterator().next();
                adj.get(adjNode).remove(leaf);
                if (adj.get(adjNode).size() == 1) {
                    newLeaves.add(adjNode);
                }
                leaves = newLeaves;
            }
        }
        return leaves;
    }
}
