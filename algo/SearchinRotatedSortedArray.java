class SearchinRotatedSortedArray {
    //Approach 1: Binary search
    //Time Complexity:O(logN)
    //Space Complexity: O(1) 
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        
        int low = 0;
        int high = nums.length-1;
        int indexOfMax = -1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (mid == high || nums[mid] > nums[mid+1]) {
                indexOfMax = mid;
                break;
            }
            if (nums[mid] > nums[low]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (indexOfMax == -1) {
            return indexOfMax;
        }
        int res = binarySearch(nums, target, 0, indexOfMax);
        if (res == -1) {
            res = binarySearch(nums, target, indexOfMax+1, nums.length-1);
        }
        
        return res;
    }
    
    public int binarySearch(int[] nums, int target,int low,int high) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}