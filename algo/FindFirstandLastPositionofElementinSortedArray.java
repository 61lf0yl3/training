class FindFirstandLastPositionofElementinSortedArray {

    // Approach 1: Binary Search
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == low || nums[mid - 1] < target)) {
                res[0] = mid;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == high || target < nums[mid + 1])) {
                res[1] = mid;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}