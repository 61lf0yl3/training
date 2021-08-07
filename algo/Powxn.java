class Powxn {
    // 50. Pow(x, n)

    // Approach 1: Brute Force (TLE)
    // Time complexity : O(N)
    // Space complexity : O(1)
    public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        for (int i = 0; i < N; i++) {
            res *= x;
        }
        return res;
    }

    // Approach 2: Recursion
    // Time complexity : O(N)
    // Space complexity : O(1)
    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    // Approach 3: Iterative
    // Time complexity : O(N)
    // Space complexity : O(1)
    public double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        double curr_prod = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res = res * curr_prod;
            }
            curr_prod = curr_prod * curr_prod;
        }
        return res;
    }
}