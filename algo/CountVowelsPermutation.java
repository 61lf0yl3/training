class CountVowelsPermutation {
    // 1220. Count Vowels Permutation

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

    private long[][] memo;
    private int MOD = 1000000007;

    // Approach 2: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int countVowelPermutation3(int n) {
        // each row stands for the length of string
        // each column indicates the vowels
        // specifically, a: 0, e: 1, i: 2, o: 3, u: 4
        memo = new long[n][5];
        long result = 0;
        for (int i = 0; i < 5; i++) {
            result = (result + vowelPermutationCount(n - 1, i)) % MOD;
        }
        return (int) result;
    }

    public long vowelPermutationCount(int i, int vowel) {
        if (memo[i][vowel] != 0)
            return memo[i][vowel];
        if (i == 0) {
            memo[i][vowel] = 1;
        } else {
            if (vowel == 0) {
                memo[i][vowel] = (vowelPermutationCount(i - 1, 1) + vowelPermutationCount(i - 1, 2)
                        + vowelPermutationCount(i - 1, 4)) % MOD;
            } else if (vowel == 1) {
                memo[i][vowel] = (vowelPermutationCount(i - 1, 0) + vowelPermutationCount(i - 1, 2)) % MOD;
            } else if (vowel == 2) {
                memo[i][vowel] = (vowelPermutationCount(i - 1, 1) + vowelPermutationCount(i - 1, 3)) % MOD;
            } else if (vowel == 3) {
                memo[i][vowel] = vowelPermutationCount(i - 1, 2);
            } else if (vowel == 4) {
                memo[i][vowel] = (vowelPermutationCount(i - 1, 2) + vowelPermutationCount(i - 1, 3)) % MOD;
            }
        }
        return memo[i][vowel];
    }
}