package java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DFS
 * 
 * </pre>
 */
class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!helper(adj, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(Map<Integer, List<Integer>> adj, int[] visited, int course) {
        if (visited[course] == 1) {
            return false;
        }
        visited[course] = 1;
        for (Integer e : adj.get(course)) {
            if (visited[e] < 2) {
                if (!helper(adj, visited, e)) {
                    return false;
                }
            }
        }
        visited[course] = 2;
        return true;
    }
}


/**
 * <pre>
 * 
 * BFS
 * 
 * </pre>
 */
class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offerLast(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            for (int neighbor : adj.get(vertex)) {
                if (--degree[neighbor] == 0) {
                    queue.offerLast(neighbor);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
