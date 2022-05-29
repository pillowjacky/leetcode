package java;

import java.util.LinkedList;

/**
 * <pre>
 * 
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 * 
 * </pre>
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var result = new LinkedList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[0][0]);
    }
}
