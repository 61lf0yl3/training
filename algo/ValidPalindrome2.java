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

}