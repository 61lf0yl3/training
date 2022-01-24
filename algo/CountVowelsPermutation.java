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

    // Approach 1: DP Bottom-up
    // Time Complexity: O(N)
    // Space Complexity: O(n)
    public int countVowelPermutation2(int n) {

        long[] aVowelPermutationCount = new long[n];
        long[] eVowelPermutationCount = new long[n];
        long[] iVowelPermutationCount = new long[n];
        long[] oVowelPermutationCount = new long[n];
        long[] uVowelPermutationCount = new long[n];

        aVowelPermutationCount[0] = 1L;
        eVowelPermutationCount[0] = 1L;
        iVowelPermutationCount[0] = 1L;
        oVowelPermutationCount[0] = 1L;
        uVowelPermutationCount[0] = 1L;

        int MOD = 1000000007;

        for (int i = 1; i < n; i++) {
            aVowelPermutationCount[i] = (eVowelPermutationCount[i - 1] + iVowelPermutationCount[i - 1]
                    + uVowelPermutationCount[i - 1]) % MOD;
            eVowelPermutationCount[i] = (aVowelPermutationCount[i - 1] + iVowelPermutationCount[i - 1]) % MOD;
            iVowelPermutationCount[i] = (eVowelPermutationCount[i - 1] + oVowelPermutationCount[i - 1]) % MOD;
            oVowelPermutationCount[i] = iVowelPermutationCount[i - 1] % MOD;
            uVowelPermutationCount[i] = (iVowelPermutationCount[i - 1] + oVowelPermutationCount[i - 1]) % MOD;
        }

        long result = 0L;

        result = (aVowelPermutationCount[n - 1] + eVowelPermutationCount[n - 1] + iVowelPermutationCount[n - 1]
                + oVowelPermutationCount[n - 1] + uVowelPermutationCount[n - 1]) % MOD;

        return (int) result;
    }
}