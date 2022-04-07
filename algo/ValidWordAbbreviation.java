public class ValidWordAbbreviation {
    // Approach 1: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (abbr.charAt(j) == '0') {
                return false;
            }
            int num = 0;
            while (j < m && Character.isDigit(abbr.charAt(j))) {
                num = num * 10 + (abbr.charAt(j) - '0');
                j++;
            }
            i += num;
            if (i < n && j < m && word.charAt(i++) != abbr.charAt(j++)) {
                return false;
            }
        }
        return i == n && j == m;
    }
}
