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

    // Approach 1: Compare with Reverse
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean isPalindrome2(String s) {
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        }

        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();

        return filteredString.equals(reversedString);
    }

    /** An alternate solution using Java 8 Streams */
    public boolean isPalindromeUsingStreams(String s) {
        StringBuilder builder = new StringBuilder();

        s.chars()
                .filter(c -> Character.isLetterOrDigit(c))
                .mapToObj(c -> Character.toLowerCase((char) c))
                .forEach(builder::append);

        return builder.toString().equals(builder.reverse().toString());
    }
}