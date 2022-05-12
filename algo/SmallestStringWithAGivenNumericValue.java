class SmallestStringWithAGivenNumericValue {
    // 1663. Smallest String With A Given Numeric Value

    // Approach 1: Build number from left to right
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            if (k >= 26 + i) {
                k -= 26;
                chars[i] = 'z';
            } else {
                int temp = k - i;
                chars[i] = (char) (k - i + 'a' - 1);
                k -= temp;
            }
        }
        return String.valueOf(chars);
    }
}