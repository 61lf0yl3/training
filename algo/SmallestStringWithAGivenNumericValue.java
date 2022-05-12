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

    // Approach 1: Build number from left to right
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public String getSmallestString2(int n, int k) {
        char[] result = new char[n];
        for (int position = 0; position < n; position++) {
            int positionsLeft = (n - position - 1);
            if (k > positionsLeft * 26) {
                int add = k - (positionsLeft * 26);
                result[position] = (char) ('a' + add - 1);
                k -= add;
            } else {
                result[position] = 'a';
                k--;
            }
        }
        return new String(result);
    }

    // Approach 2: Build number from right
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public String getSmallestString3(int n, int k) {
        char[] result = new char[n];
        Arrays.fill(result, 'a');
        k -= n;
        for (int position = n - 1; position >= 0 && k > 0; position--) {
            int add = Math.min(k, 25);
            result[position] = (char) (result[position] + add);
            k -= add;
        }
        return new String(result);
    }

    // Approach 2: Build number from right - Optimised solution
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public String getSmallestString4(int n, int k) {
        char[] result = new char[n];
        for (int position = n - 1; position >= 0; position--) {
            int add = Math.min(k - position, 26);
            result[position] = (char) (add + 'a' - 1);
            k -= add;
        }
        return new String(result);
    }
}