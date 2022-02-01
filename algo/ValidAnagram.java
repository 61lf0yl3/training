public class ValidAnagram {
    // Approach #2 (Hash Table) [Accepted]
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sArr[sChar - 'a']++;
            tArr[tChar - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;
    }

}
