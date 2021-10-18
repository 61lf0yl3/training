class Solution {
    // O(n^2*logn) bruteforce
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), true);
            max = Math.max(map.size(), max);
            for (int j=i+1; j<s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    max = Math.max(map.size(), max);
                    map.clear();
                    break;
                } else {
                    map.put(s.charAt(j), true);
                    max = Math.max(map.size(), max);
                }     
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }
}