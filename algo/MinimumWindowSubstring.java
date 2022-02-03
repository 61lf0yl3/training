class MinimumWindowSubstring {
    // Approach 1: Sliding Window (TLM)
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public String minWindow(String s, String t) {
        String res = "";
        int low = 0;
        int high = t.length() - 1;
        while (high < s.length()) {
            int[] temp = new int[58];
            for (int i = low; i <= high; i++) {
                char c = s.charAt(i);
                temp[c - 'A']++;
            }
            boolean FLAG = true;
            for (char c : t.toCharArray()) {
                if (temp[c - 'A'] == 0) {
                    FLAG = false;
                    break;
                }
                temp[c - 'A']--;
            }
            if (FLAG) {
                String sub = s.substring(low, high + 1);
                if (res.length() == 0 || sub.length() < res.length()) {
                    res = sub;
                }
                low++;
            } else {
                high++;
            }
        }

        return res;
    }
}