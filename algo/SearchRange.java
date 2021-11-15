class SearchRange {
    //Approach: Binary Search
    //Time complexity : O(logN)
    //Space complexity : O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int first = binarySearch(nums,target,true);
        if (first == -1) {
            return res;
        }
        int second = binarySearch(nums,target,false);
        res[0]=first;
        res[1]=second;
        return res;
    }
    
    public int binarySearch(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length-1;
        while (high >= low) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                if (isFirst){
                    // This means we found our lower bound
                    if ( mid == low || nums[mid-1] != target) {
                        return mid;
                    } 
                    // Search on the left side for the bound.
                    high = mid - 1;
                } else {
                    // This means we found our upper bound.
                    if (mid == high || nums[mid+1] != target) {
                        return mid;
                    }
                    // Search on the right side for the bound.
                    low = mid+1;
                }
            }
            if (nums[mid] < target) {
                low = mid+1;
            } else if (nums[mid]>target) {
                high = mid-1;
            }
        }
        return -1;
    }
}