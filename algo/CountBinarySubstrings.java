class CountBinarySubstrings {
    // Approach 1: My version
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countBinarySubstrings(String s) {
        int res = 0;
        int zeros = 0;
        int ones = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (prev == '1' && i != 0) {
                    zeros = 1;
                } else {
                    zeros++;
                }
                prev = '0';
            } else {
                if (prev == '0' && i != 0) {
                    ones = 1;
                } else {
                    ones++;
                }
                prev = '1';
            }
            if (zeros > 0 && ones > 0) {
                res++;
                if (prev == '1') {
                    zeros--;
                } else {
                    ones--;
                }
            }
        }
        return res;
    }
}