package java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <pre>
 * 
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * DFS, Topological Sort
 * 
 * </pre>
 */
class Solution1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }
        List<Integer> out = new ArrayList<>(numCourses);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!helper(adj, visited, i, out)) {
                    return new int[0];
                }
            }
        }
        return out.stream().mapToInt(i -> i).toArray();
    }

    private boolean helper(List<List<Integer>> adj, int[] visited, int course, List<Integer> out) {
        if (visited[course] == 1) {
            return false;
        }
        visited[course] = 1;
        for (Integer e : adj.get(course)) {
            if (visited[e] < 2) {
                if (!helper(adj, visited, e, out)) {
                    return false;
                }
            }
        }
        visited[course] = 2;
        out.add(course);
        return true;
    }
}


/**
 * <pre>
 * 
 * BFS, Topological Sort
 * 
 * </pre>
 */
class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] out = new int[numCourses];
        int idx = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offerLast(i);
                out[idx++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            for (int neighbor : adj.get(vertex)) {
                if (--degree[neighbor] == 0) {
                    queue.offerLast(neighbor);
                    out[idx++] = neighbor;
                }
            }
        }
        return idx == numCourses ? out : new int[0];
    }
}
