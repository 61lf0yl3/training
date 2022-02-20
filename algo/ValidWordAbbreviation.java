public class ValidWordAbbreviation {
    // Approach 1: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean validWordAbbreviation(String word, String abbr) {
        int m = abbr.length();
        int n = word.length();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int temp = 0;
            if (abbr.charAt(i) == '0') {
                return false;
            }
            while (i < m && Character.isDigit(abbr.charAt(i))) {
                temp = temp * 10 + (abbr.charAt(i++) - '0');
            }
            j += temp;
            if (i < m && j < n && abbr.charAt(i++) != word.charAt(j++)) {
                return false;
            }
        }
        return i == m && j == n;
    }
}
