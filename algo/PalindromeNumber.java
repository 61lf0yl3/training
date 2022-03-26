class PalindromeNumber {
    // 9. Palindrome Number

    // Approach 1: Revert half of the number
    // Time complexity : O(logN)
    // Space complexity : O(1)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
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