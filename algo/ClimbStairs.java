class ClimbStairs {
    //Approach 1: Brute Force
    //Time complexity : O(2^n)
    //Space complexity : O(n)
    public int climbStairs(int n) {
        return climbStairsR(n, n);
    }
    public int climbStairsR(int n, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        return climbStairsR(n, i-1) + climbStairsR(n, i-2);
    }

    //Approach 1: Recursion with Memoization
    //Time complexity : O(n)
    //Space complexity : O(n)
    public int climbStairs2(int n) {
        int[] memory = new int[n+1];
        return climbStairsR2(n, n, memory);
    }
    public int climbStairsR2(int n, int i, int[] memory) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (memory[i] != 0) {
            return memory[i];
        }
        memory[i] = climbStairsR2(n, i-1, memory) + climbStairsR2(n, i-2, memory);
        return memory[i];
    }

    //Approach 3: Dynamic Programming
    //Time complexity : O(n)
    //Space complexity : O(n)
    public int climbStairs3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //Approach 4: Fibonacci Number
    //Time complexity : O(n)
    //Space complexity : O(1)
    public int climbStairs4(int n) {
        if (n == 1) {return 1;}
        int first = 1;
        int second = 2;
        for (int i = 3; i<=n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}