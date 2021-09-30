class Solution {
    public int search(int[] nums, int key) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (key == nums[mid]) {
                return mid;
            } else if (key < nums[mid]) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low<high) {
            int mid = low + (high-low)/2;
            if (!isBadVersion(mid)) {
                low = mid +1;
            } else {
                high = mid;
            }              
        }
        return low;
    }
}