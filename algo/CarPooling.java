import java.util.Map;
import java.util.TreeMap;

class CarPooling {
    // Approach 1: Bucket Sort
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] m = new int[1001];
        for (int[] trip : trips) {
            m[trip[1]]+=trip[0];
            m[trip[2]]-=trip[0];
        }
        
        for (int key : m) {
            capacity -= key;
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
            m.put(trip[1], m.getOrDefault(trip[1], 0)+trip[0]);
            m.put(trip[2], m.getOrDefault(trip[2], 0)-trip[0]);
        }
        
        for (int key : m.values()) {
            capacity -= key;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
    }
}