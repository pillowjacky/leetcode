package _973_k_closest_points_to_origin;

import java.util.ArrayList;
import java.util.List;

public class OptimizationBinarySearch {
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
