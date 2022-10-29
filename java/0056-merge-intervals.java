package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * 
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * 
 * </pre>
 */

class Solutions {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] last = ans.get(ans.size() - 1);
            if (last[1] >= interval[0]) {
                last[1] = Integer.max(last[1], interval[1]);
            } else {
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
