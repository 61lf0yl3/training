class CountBinarySubstrings {
    // 696. Count Binary Substrings

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

    // Approach 2: Group By Character
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int countBinarySubstrings2(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i - 1], groups[i]);
        }
        return ans;
    }

    // Approach 1: Linear Scan
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countBinarySubstrings3(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
}