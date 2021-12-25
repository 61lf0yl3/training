public class IsPalindrom {
    public static boolean isPalindrom(String text) {
        int length = text.length();
        // Separate case for shortest strings.
        if (length <= 1) {
            return true;
        } else {
            // Get first and last characters, converted to lowercase.
            char first = Character.toLowerCase(text.charAt(0));
            char last = Character.toLowerCase(text.charAt(length - 1));
            if (Character.isLetter(first) && Character.isLetter(last)) {
                // Both are letters.
                if (first == last) {
                    // Remove both first and last character.
                    String shorter = text.substring(1, length - 1);
                    return isPalindrome(shorter);
                } else {
                    return false;
                }
            } else if (!Character.isLetter(last)) {
                // Remove last character.
                String shorter = text.substring(0, length - 1);
                return isPalindrome(shorter);
            } else {
                // Remove first character.
                String shorter = text.substring(1);
                return isPalindrome(shorter);
            }
        }
    }
}