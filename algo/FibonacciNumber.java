import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    // Approach 4: Iterative Bottom-Up Approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int oldest = 0;
        int old = 1;
        for (int i = 2; i <= n; i++) {
            int temp = oldest + old;
            oldest = old;
            old = temp;
        }
        return old;
    }

    // Approach 4: Top-Down Approach
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    // Creating a hash map with 0 -> 0 and 1 -> 1 pairs
    private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    public int fib3(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        cache.put(N, fib(N - 1) + fib(N - 2));
        return cache.get(N);
    }

    // Approach 6: Math
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int fib2(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
    }
}
