class FindMinimuminRotatedSortedArray {
   // 153. Find Minimum in Rotated Sorted Array


    //Approach 1: Binary Search
    //Time Complexity:O(logN)
    //Space Complexity: O(1)
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        if (nums[low] <= nums[high]) {
            return nums[0];
        }
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            } else if (nums[mid]>nums[low]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return nums[0];
    }
}