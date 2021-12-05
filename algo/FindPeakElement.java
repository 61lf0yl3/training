class FindPeakElement {
    //162. Find Peak Element

    //Approach 1: Binary Search
    //Time Complexity:O(logN)
    //Space Complexity: O(1)
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high) {
            int mid = low + (high-low)/2;
            if (nums[mid]>nums[mid+1]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}