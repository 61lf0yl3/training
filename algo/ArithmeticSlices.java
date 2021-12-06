class ArithmeticSlices {
    //413. Arithmetic Slices

    // Approach 1: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        for (int i = 3; i<=nums.length;i++ ) {
            for (int j=0; j <= nums.length-i; j++) {
                int diff = nums[j]-nums[j+1];
                for (int n = j; n < j+i; n++) {
                    if (n == i+j-1) {
                        res++;
                    } else if (nums[n]-nums[n+1]!=diff) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}