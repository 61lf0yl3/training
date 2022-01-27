class InterleavingString {
    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N*M) Maximum day in days
    // Space Complexity: O(N*M)
    String s1;
    String s2;
    String s3;
    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s3.length() == 0) {
            return true;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        memo = new Boolean[s1.length()][s2.length()];
        return isInterleaveDP(0, 0);
    }

    private boolean isInterleaveDP(int i, int j) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(i + j));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(i + j));
        }
        if (memo[i][j] == null) {
            boolean ret = false;
            if (s1.charAt(i) == s3.charAt(i + j) && isInterleaveDP(i + 1, j)) {
                ret = true;
            }
            if (s2.charAt(j) == s3.charAt(i + j) && isInterleaveDP(i, j + 1)) {
                ret = true;
            }
            memo[i][j] = ret;
        }
        return memo[i][j];
    }
}