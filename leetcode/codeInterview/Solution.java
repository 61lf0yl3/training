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
}