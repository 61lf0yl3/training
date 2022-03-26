import java.util.ArrayList;

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
        ArrayList<Integer> groups = new ArrayList<>();
        groups.add(1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                int index = groups.size() - 1;
                int num = groups.get(index) + 1;
                groups.set(index, num);
            } else {
                groups.add(1);
            }
        }
        int res = 0;
        for (int i = 1; i < groups.size(); i++) {
            res += Math.min(groups.get(i - 1), groups.get(i));
        }
        return res;
    }

    // Approach 1: Linear Scan
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countBinarySubstrings3(String s) {
        int res = 0;
        int prev = 0;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                curr++;
            } else {
                res += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        res += Math.min(prev, curr);
        return res;
    }
}