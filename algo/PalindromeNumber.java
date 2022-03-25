class PalindromeNumber {
    // 9. Palindrome Number

    // Approach 1: Revert half of the number
    // Time complexity : O(logN)
    // Space complexity : O(1)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int newX = x;
        int res = 0;
        while (newX > 0) {
            res = res * 10 + newX % 10;
            newX /= 10;
        }
        return res == x;
    }
}