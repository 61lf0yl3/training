class FindPeakElement {
    // 162. Find Peak Element

    // Approach 1: Binary Search
    // Time Complexity:O(logN)
    // Space Complexity: O(1)
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Approach 1: Recursive Binary Search
    // Time Complexity:O(logN)
    // Space Complexity: O(1)
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    // Approach 1: Binary Search
    // Time Complexity:O(logN)
    // Space Complexity: O(1)
    public int findPeakElement3(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long left = (long) nums[mid] - 1;
            if (mid > 0) {
                left = nums[mid - 1];
            }
            long right = (long) nums[mid] + 1;
            if (mid < nums.length - 1) {
                right = nums[mid + 1];
            }
            if (left < nums[mid] && right < nums[mid]) {
                return mid;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}