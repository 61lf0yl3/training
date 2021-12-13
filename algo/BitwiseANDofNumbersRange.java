class BitwiseANDofNumbersRange {
    // 201. Bitwise AND of Numbers Range

    // Approach 1: Bit Shift
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int rangeBitwiseAnd(int left, int right) {
        int counter = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            counter++;
        }
        left = left << counter;

        return left;
    }
}