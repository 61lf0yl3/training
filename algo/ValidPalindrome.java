class ValidPalindrome {
    // 125. Valid Palindrome

    // Approach 1: Two Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                return false;
            }
        }
        return true;
    }
}