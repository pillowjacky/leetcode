package _973_k_closest_points_to_origin;

import java.util.Arrays;

public class BruteForce {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (e1, e2) -> calDistance(e1) - calDistance(e2));
        return Arrays.copyOf(points, k);
    }

    private int calDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
