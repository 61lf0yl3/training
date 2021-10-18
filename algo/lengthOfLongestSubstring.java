class Solution {
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
}