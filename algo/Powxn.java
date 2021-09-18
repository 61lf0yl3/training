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
}