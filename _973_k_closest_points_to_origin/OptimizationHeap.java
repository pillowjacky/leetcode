package _973_k_closest_points_to_origin;

import java.util.PriorityQueue;
import java.util.Queue;

public class OptimizationHeap {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((e1, e2) -> e2[0] - e1[0]);
        for (int i = 0; i < points.length; i++) {
            int[] e = {calDistance(points[i]), i};
            if (maxHeap.size() < k) {
                maxHeap.add(e);
            } else if (maxHeap.peek()[0] > e[0] ) {
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
