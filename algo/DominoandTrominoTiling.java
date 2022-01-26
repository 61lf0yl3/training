import java.util.HashMap;
import java.util.Map;

class DominoandTrominoTiling {
    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int MOD = 1_000_000_007;
    Map<Integer, Long> f_cache = new HashMap<>();
    Map<Integer, Long> p_cache = new HashMap<>();

    public long p(int n) {
        if (p_cache.containsKey(n)) {
            return p_cache.get(n);
        }
        long val;
        if (n == 2) {
            val = 1L;
        } else {
            val = (p(n - 1) + f(n - 2)) % MOD;
        }
        p_cache.put(n, val);
        return val;

    }

    public long f(int n) {
        if (f_cache.containsKey(n)) {
            return f_cache.get(n);
        }
        long val;
        if (n == 1) {
            val = 1L;
        } else if (n == 2) {
            val = 2L;
        } else {
            val = (f(n - 1) + f(n - 2) + 2 * p(n - 1)) % MOD;
        }
        f_cache.put(n, val);
        return val;
    }

    public int numTilings(int n) {
        return (int) (f(n));
    }

    // Approach 2: DP Bottom-up
    // Time Complexity: O(N)
    // Space Complexity: O(n)
    public int numTilings2(int n) {
        int MOD = 1_000_000_007;
        // handle base case scenarios
        if (n <= 2) {
            return n;
        }
        // f[k]: number of ways to "fully cover a board" of width k
        long[] f = new long[n + 1];
        // p[k]: number of ways to "partially cover a board" of width k
        long[] p = new long[n + 1];
        // initialize f and p with results for the base case scenarios
        f[1] = 1L;
        f[2] = 2L;
        p[2] = 1L;
        for (int k = 3; k < n + 1; ++k) {
            f[k] = (f[k - 1] + f[k - 2] + 2 * p[k - 1]) % MOD;
            p[k] = (p[k - 1] + f[k - 2]) % MOD;
        }
        return (int) (f[n]);
    }
}