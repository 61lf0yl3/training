class BitwiseANDofNumbersRange {
    // 201. Bitwise AND of Numbers Range

    // The idea is that we shift both numbers to the right, until the numbers become
    // equal, i.e. the numbers are reduced into their common prefix. Then we append
    // zeros to the common prefix in order to obtain the desired result, by shifting
    // the common prefix to the left.

    // Approach 1: Bit Shift
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int rangeBitwiseAnd(int left, int right) {
        int counter = 0;
        // find the common 1-bits
        while (left != right) {
            left >>= 1;
            right >>= 1;
            counter++;
        }
        left = left << counter;

        return left;
    }

    // Approach 2: Brian Kernighan's Algorithm
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int rangeBitwiseAnd2(int left, int right) {
        while (right > left) {
            // turn off rightmost 1-bit
            right &= right - 1;
        }
        return right & left;
    }
}