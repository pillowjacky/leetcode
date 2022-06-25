package _973_k_closest_points_to_origin;

import java.util.Arrays;

public class OptimizationQuickSelect {
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
