class KthMissingPositiveNumber {

    // Approach 2: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) {
            return k;
        }

        k -= arr[0] - 1;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int missing = arr[i] - arr[i - 1] - 1;
            if (missing >= k) {
                return arr[i - 1] + k;
            }
            k -= missing;
        }
        return arr[n - 1] + k;
    }

    // Approach 3: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findKthPositive3(int[] arr, int k) {
        int[] nums = new int[1001];
        for (int i : arr) {
            nums[i] = 1;
        }
        for (int i = 1; i <= 1000; i++) {
            if (nums[i] == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return k + 1000;
    }
}