import java.util.HashMap;
import java.util.Map;

class DecodeWays {
    // 91. Decode Ways

    // Approach 1: Recursive
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }

    private int recursiveWithMemo(int index, String str) {
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }

        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }

    // Approach 2: Dynamic Programming
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int numDecodings2(String s) {
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        if (s.charAt(0) != '0') {
            memo[1] = 1;
        }
        for (int i = 2; i < memo.length; i++) {
            if (s.charAt(i - 1) != '0') {
                memo[i] = memo[i - 1];
            }
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                memo[i] += memo[i - 2];
            }
        }
        return memo[s.length()];
    }

    // Approach 4: Constant Space Dynamic Programming
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int numDecodings3(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int oldest = 1;
        int old = 0;
        if (s.charAt(0) != '0') {
            old = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            int curr = 0;
            if (s.charAt(i) != '0') {
                curr = old;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += oldest;
            }
            oldest = old;
            old = curr;
        }
        return old;
    }

    String s;
    Integer[] memo1;

    public int numDecodings4(String s) {
        this.s = s;
        memo1 = new Integer[s.length()];
        return numDecodingsDP(0);
    }

    private int numDecodingsDP(int i) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (i == s.length() - 1) {
            return 1;
        }
        if (memo1[i] == null) {
            memo1[i] = numDecodingsDP(i + 1);
            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                memo1[i] += numDecodingsDP(i + 2);
            }
        }
        return memo1[i];
    }

    public int numDecodings5(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}