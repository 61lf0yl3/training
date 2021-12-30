class BeautifulArrangement {
    // 526. Beautiful Arrangement

    // Approach 1: Brute Force
    // Time complexity : O(k) where k refers to the number of valid permutations
    // Space complexity : O(n)
    int res;

    public int countArrangement(int n) {
        res = 0;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        if (start >= nums.length) {
            res++;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            if ((start + 1) % nums[start] == 0 || nums[start] % (start + 1) == 0) {
                backtrack(nums, start + 1);
            }
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    // Approach 1: Backtracking
    // Time complexity : O(k) where k refers to the number of valid permutations
    // Space complexity : O(n)

    public int countArrangement2(int n) {
        res = 0;
        boolean[] seen = new boolean[n + 1];
        backtrack(n, 1, seen);
        return res;
    }

    public void backtrack(int n, int pos, boolean[] seen) {
        if (pos > n) {
            res++;
        }
        for (int i = 1; i <= n; i++) {
            if (!seen[i] && (i % pos == 0 || pos % i == 0)) {
                seen[i] = true;
                backtrack(n, pos + 1, seen);
                seen[i] = false;
            }
        }
    }

}