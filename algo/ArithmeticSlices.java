class ArithmeticSlices {
    // 413. Arithmetic Slices

    // Approach 1: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        for (int i = 3; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length - i; j++) {
                int diff = nums[j] - nums[j + 1];
                for (int n = j; n < j + i; n++) {
                    if (n == i + j - 1) {
                        res++;
                    } else if (nums[n] - nums[n + 1] != diff) {
                        break;
                    }
                }
            }
        }
        return res;
    }

    // Approach 2: Better Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int numberOfArithmeticSlices2(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }

    // Approach 3: Recursion
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int sum;

    public int numberOfArithmeticSlices3(int[] A) {
        sum = 0;
        slices(A, A.length - 1);
        return sum;
    }

    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else
            slices(A, i - 1);
        return ap;
    }

    // Approach 4: DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int numberOfArithmeticSlices4(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    // Approach 4: Constant Space Dynamic Programming
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int numberOfArithmeticSlices5(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else
                dp = 0;
        }
        return sum;
    }
}