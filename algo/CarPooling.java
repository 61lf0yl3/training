import java.util.Map;
import java.util.TreeMap;

class CarPooling {
    // Approach 1: Bucket Sort
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }

        for (int currCapacity : timestamp) {
            capacity -= currCapacity;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    // Approach 2: Time Stamp
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public boolean carPooling2(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();

        for (int[] trip : trips) {
            int startPassenger = m.getOrDefault(trip[1], 0) + trip[0];
            m.put(trip[1], startPassenger);

            int endPassenger = m.getOrDefault(trip[2], 0) - trip[0];
            m.put(trip[2], endPassenger);

        }
        int currCapacity = 0;
        for (int val : m.values()) {
            currCapacity += val;
            if (currCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}