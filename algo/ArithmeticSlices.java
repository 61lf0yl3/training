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
    
    // Approach 2: Better Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int numberOfArithmeticSlices2(int[] A) {
        int count = 0;
        for (int s = 0; s < A.length - 2; s++) {
            int d = A[s + 1] - A[s];
            for (int e = s + 2; e < A.length; e++) {
                if (A[e] - A[e - 1] == d)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}