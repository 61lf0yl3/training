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

    // Approach 3: DP
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public String longestPalindrome2(String s) {
        String res = ""+s.charAt(0);
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        for (int r = s.length()-1; r >=0; r--) {
            for (int c = r; c < s.length(); c++) {
                if (s.charAt(r)==s.charAt(c)) {
                    if (r==c) {
                        isPalindrome[r][c] = true;
                    } else if (c-r+1==3 || c-r+1==2) {
                        isPalindrome[r][c] = true;
                        if (c-r+1>res.length()) {
                            res = s.substring(r,c+1);
                        }
                    } else {
                        if(isPalindrome[r+1][c-1]) {
                            isPalindrome[r][c] = true;
                            if (c-r+1>res.length()) {
                                res = s.substring(r,c+1);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}