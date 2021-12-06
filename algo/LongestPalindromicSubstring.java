class LongestPalindromicSubstring {

    // Approach 2: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public String longestPalindrome(String s) {
        String res = "" + s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, j + 1);
                if (isPalindrome(temp)) {
                    res = temp;
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }
}