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
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return myPowR(x, N);
    }

    private double myPowR(double x, long n) {
        if (n < 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double res = myPowR(x, n / 2);
            return res * res;
        } else {
            double res = myPowR(x, n / 2);
            return x * res * res;
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