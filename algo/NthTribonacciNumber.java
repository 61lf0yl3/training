import java.util.HashMap;
import java.util.Map;

class NthTribonacciNumber {
    // 1137. N-th Tribonacci Number

    // Approach 1: DP Optimal
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n];
        int grand = 0;
        int dad = 1;
        int son = 1;
        for (int i = 3; i <= n; i++) {
            int temp = son;
            son += grand + dad;
            grand = dad;
            dad = temp;
        }
        return son;
    }

    // Approach 1: DP (Recursion+Memoization)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        return tribonacciDP(n);
    }

    Map<Integer, Integer> m = new HashMap<>();

    private int tribonacciDP(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        if (!m.containsKey(n)) {
            m.put(n, tribonacciDP(n - 1) + tribonacciDP(n - 2) + tribonacciDP(n - 3));
        }
        return m.get(n);
    }
}