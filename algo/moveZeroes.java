class Solution {
    // O(n^2)
    public void moveZeroes(int[] nums) {
        int i = 0;
        int end = nums.length;
        while (i < end) {
            if (nums[i]==0) {
                for (int j=i;j<nums.length-1; j++) {
                nums[j] = nums[j+1];
                }
                nums[nums.length-1]=0;
                end--;
            }  else {
                i++;
            }
        }
    }

    // O(n) sub-optimal
    public void moveZeroes2(int[] nums) {
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                nums[i-countZero] = nums[i];
            }
        }
        for (int i = nums.length-1; i > nums.length-1 -countZero; i-- ) {
            nums[i] = 0;
        }
    }

    // O(n) optimal
    public void moveZeroes3(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
}