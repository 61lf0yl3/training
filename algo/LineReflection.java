import java.util.HashSet;
import java.util.Set;

class LineReflection {
    // Approach 1: Iterative Using HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();

        for (int[] point : points) {
            set.add(point[0] + ";" + point[1]);
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
        }

        int sum = max + min;

        for (int[] point : points) {
            if (!set.contains((sum - point[0]) + ";" + point[1])) {
                return false;
            }
        }
        return true;
    }
}