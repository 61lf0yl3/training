class SingleElementinaSortedArray {
    // 540. Single Element in a Sorted Array

    // Approach 1: Binary Search
    // Time complexity : O(logN)
    // Space complexity : O(1)
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[low];
    }
}