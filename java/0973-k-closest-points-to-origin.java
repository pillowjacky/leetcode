package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <pre>
 * 
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * </pre>
 */

/**
 * <pre>
 * 
 * Brute Force
 * 
 * </pre.
 */
class Solution1 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (e1, e2) -> calDistance(e1) - calDistance(e2));
        return Arrays.copyOf(points, k);
    }

    private int calDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}


/**
 * <pre>
 * 
 * Binary Search
 * 
 * </pre>
 */
class Solution2 {
    public int[][] kClosest(int[][] points, int k) {
        double[] distances = new double[points.length];
        double high = 0;
        double low = 0;

        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            distances[i] = calDistance(points[i]);
            high = Math.max(high, distances[i]);
            remaining.add(i);
        }

        List<Integer> closest = new ArrayList<>();
        while (k > 0) {
            double mid = (high - low) / 2 + low;
            List<Integer> closer = new ArrayList<>();
            List<Integer> farther = new ArrayList<>();
            for (int i : remaining) {
                if (distances[i] <= mid) {
                    closer.add(i);
                } else {
                    farther.add(i);
                }
            }

            if (closer.size() > k) {
                remaining = closer;
                high = mid;
            } else {
                closest.addAll(closer);
                k -= closer.size();
                remaining = farther;
                low = mid;
            }
        }

        k = closest.size();
        int[][] out = new int[k][2];
        for (int i = 0; i < k; i++) {
            out[i] = points[closest.get(i)];
        }
        return out;
    }

    private int calDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}


/**
 * <pre>
 * 
 * Heap
 * 
 * </pre>
 */
class Solution3 {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((e1, e2) -> e2[0] - e1[0]);
        for (int i = 0; i < points.length; i++) {
            int[] e = {calDistance(points[i]), i};
            if (maxHeap.size() < k) {
                maxHeap.add(e);
            } else if (maxHeap.peek()[0] > e[0]) {
                maxHeap.poll();
                maxHeap.add(e);
            }
        }

        int[][] out = new int[k][2];
        for (int i = 0; i < k; i++) {
            out[i] = points[maxHeap.poll()[1]];
        }
        return out;
    }

    private int calDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}


/**
 * <pre>
 * 
 * Quick Select
 * 
 * </pre>
 */
class Solution4 {
    public int[][] kClosest(int[][] points, int k) {
        if (points.length == k) {
            return points;
        }
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int start, int end, int k) {
        int pivot = partition(points, start, end);
        if (pivot == k) {
            return;
        } else if (pivot < k) {
            quickSelect(points, pivot, end, k);
        } else {
            quickSelect(points, start, pivot - 1, k);
        }
    }

    private int partition(int[][] points, int start, int end) {
        int pivot = calDistance(points[(end - start) / 2 + start]);
        while (start < end) {
            if (calDistance(points[start]) >= pivot) {
                swap(points, start, end);
                end--;
            } else {
                start++;
            }
        }
        if (calDistance(points[start]) < pivot) {
            start++;
        }
        return start;
    }

    private int calDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
