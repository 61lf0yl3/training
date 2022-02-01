class SumofTwoIntegers {

    // Approach 2: Bit Manipulation: Short Language-Specific Solution
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int getSum2(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }

        return a;
    }

    // Approach 1: Bit Manipulation: Easy and Language-Independent
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);

        // ensure that abs(a) >= abs(b)
        if (x < y) {
            return getSum(b, a);
        }

        // abs(a) >= abs(b) -->
        // a determines the sign
        int sign = a > 0 ? 1 : -1;

        if (a * b >= 0) {
            // sum of two positive integers x + y
            // where x > y
            while (y != 0) {
                // XOR of x and y
                int answer = x ^ y;
                // left-shifted AND of x and y
                int carry = (x & y) << 1;
                x = answer;
                y = carry;
            }
        } else {
            // difference of two positive integers x - y
            // where x > y
            while (y != 0) {
                int answer = x ^ y;
                // left-shifted AND of NOT x and y
                int borrow = ((~x) & y) << 1;
                x = answer;
                y = borrow;
            }
        }
        return x * sign;
    }
}