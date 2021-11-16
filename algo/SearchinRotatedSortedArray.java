class SearchinRotatedSortedArray {
    //Approach 1: Binary search (myway)
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


class SearchinRotatedSortedArray2 {
        int [] nums;
        int target;
      
        //Approach 1: Binary search
        //Time Complexity:O(logN)
        //Space Complexity: O(1) 
        public int find_rotate_index(int left, int right) {
          if (nums[left] < nums[right])
            return 0;
      
          while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
              return pivot + 1;
            else {
              if (nums[pivot] < nums[left])
                right = pivot - 1;
              else
                left = pivot + 1;
            }
          }
          return 0;
        }
      
        public int search(int left, int right) {
          /*
          Binary search
          */
          while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
              return pivot;
            else {
              if (target < nums[pivot])
                right = pivot - 1;
              else
                left = pivot + 1;
            }
          }
          return -1;
        }
      
        public int search(int[] nums, int target) {
          this.nums = nums;
          this.target = target;
      
          int n = nums.length;
      
          if (n == 1)
            return this.nums[0] == target ? 0 : -1;
      
          int rotate_index = find_rotate_index(0, n - 1);
      
          // if target is the smallest element
          if (nums[rotate_index] == target)
            return rotate_index;
          // if array is not rotated, search in the entire array
          if (rotate_index == 0)
            return search(0, n - 1);
          if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
          // search in the left side
          return search(0, rotate_index);
        }
      }
}