class CountVowelsPermutation {

    // Approach 1: DP Bottom-up (Space Optimizatio)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        long aCount = 1;
        long eCount = 1;
        long iCount = 1;
        long oCount = 1;
        long uCount = 1;
        for (int i = 1; i < n; i++) {
            long aCountNew = (eCount + iCount + uCount) % MOD;
            long eCountNew = (aCount + iCount) % MOD;
            long iCountNew = (eCount + oCount) % MOD;
            long oCountNew = (iCount) % MOD;
            long uCountNew = (iCount + oCount) % MOD;
            aCount = aCountNew;
            eCount = eCountNew;
            iCount = iCountNew;
            oCount = oCountNew;
            uCount = uCountNew;
        }
        long res = (aCount + eCount + iCount + oCount + uCount) % MOD;
        return (int) res;
    }
}