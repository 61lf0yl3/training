class ValidPalindrome2 {

    // Approach 1: Recursion with Two Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean validPalindrome(String s) {
        return validPalindromeR(s, 0, s.length() - 1, 1);
    }

    public boolean validPalindromeR(String s, int low, int high, int chance) {
        if (chance < 0) {
            return false;
        }
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return validPalindromeR(s, low + 1, high, chance - 1) || validPalindromeR(s, low, high - 1, chance - 1);
            } else {
                low++;
                high--;
            }
        }
        return true;
    }

    // Approach 1: Recursion with Two Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean validPalindrome2(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}