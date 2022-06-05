public class SmallestIntegerDivisiblebyK {
    // 1015. Smallest Integer Divisible by K

    // Approach 1: Checking Loop
    // Time Complexity: O(K)
    // Space Complexity: O(1)
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        for (int res = 1; res <= k; res++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return res;
            }
        }
        return -1;
    }
}
