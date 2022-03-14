import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class BusRoutes {
    // Approach #1: Breadth First Search [Accepted]
    // Time Complexity: O(N^2 + ∑(N−i)bi)
    // Space Complexity: O(N^2 + ∑bi)
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int[] route : routes) {
            Arrays.sort(route);
            graph.add(new ArrayList<>());
        }

        Set<Integer> seen = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        Queue<Point> q = new ArrayDeque<>();

        // Build the graph. Two buses are connected if
        // they share at least one bus stop.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // Initialize seen, queue, targets.
        // seen represents whether a node has ever been enqueued to queue.
        // queue handles our breadth first search.
        // targets is the set of goal states we have.
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(routes[i], source) >= 0) {
                seen.add(i);
                q.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], target) >= 0) {
                targets.add(i);
            }
        }

        while (!q.isEmpty()) {
            Point info = q.poll();
            int node = info.x;
            int depth = info.y;
            if (targets.contains(node)) {
                return depth + 1;
            }
            for (Integer nei : graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    q.offer(new Point(nei, depth + 1));
                }
            }
        }
        return -1;

    }

    private boolean intersect(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return true;
            }
            if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}