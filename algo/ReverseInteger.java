class ReverseInteger {
    // 7. Reverse Integer

    // Approach 1: Pop and Push Digits & Check before Overflow
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}