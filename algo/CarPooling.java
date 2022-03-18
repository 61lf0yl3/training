import java.util.Map;
import java.util.TreeMap;

class CarPooling {
    // Approach 1: Time Stamp
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
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