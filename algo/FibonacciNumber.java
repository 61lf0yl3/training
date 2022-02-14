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

    // Approach 6: Math
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int fib2(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
    }
}
