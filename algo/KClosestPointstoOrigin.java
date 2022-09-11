import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class KClosestPointstoOrigin {
    // 973. K Closest Points to Origin

    // Approach 1: Sort with Custom Comparator and Priority Queue
    // Time Complexity: O(NlogN)
    // Space Complexity: O(logN or N)
    public int[][] kClosest2(int[][] points, int k) {
        // Sort the array with a custom lambda comparator function
        Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));

        // Return the first k elements of the sorted array
        return Arrays.copyOf(points, k);
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }

    // Approach 1: Sort with Custom Comparator and Priority Queue
    // Time Complexity: O(NlogN)
    // Space Complexity: O(logN or N)
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }

        double[] distances = new double[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            distances[i] = distance;
        }

        PriorityQueue<Pair<Integer, Double>> q = new PriorityQueue<>(new SortDistances());

        for (int i = 0; i < distances.length; i++) {
            q.add(new Pair(i, distances[i]));
            if (q.size() > k) {
                q.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;
        while (!q.isEmpty()) {
            Pair<Integer, Double> p = q.poll();
            int i = p.getKey();
            res[index] = points[i];
            index++;
        }

        return res;
    }

    public int[][] kClosest3(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(new SortDistances2());

        for (int[] point : points) {
            q.add(point);
            if (q.size() > k) {
                q.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;
        while (!q.isEmpty()) {
            res[index] = q.poll();
            index++;
        }

        return res;
    }

    public int[][] kClosest4(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}

class SortDistances implements Comparator<Pair<Integer, Double>> {
    public int compare(Pair<Integer, Double> a, Pair<Integer, Double> b) {
        if (a.getValue() > b.getValue()) {
            return -1;
        } else if (a.getValue() < b.getValue()) {
            return 1;
        }
        return 0;
    }
}

class SortDistances implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        int distanceA = a[0] * a[0] + a[1] * a[1];
        int distanceB = b[0] * b[0] + b[1] * b[1];
        return distanceB - distanceA;
    }
}

class Solution2 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]));
        for (int[] point : points) {
            pq.add(point);
        }
        int[][] res = new int[k][2];
        while (!pq.isEmpty() && k>0) {
            res[k-- - 1] = pq.poll();
        }
        return res;
    }
    
}