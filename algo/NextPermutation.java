public class NextPermutation {
    // Approach 1: Single Pass Approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Approach 1: Single Pass Approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void nextPermutation2(int[] nums) {
        int start = nums.length - 2;
        while (start >= 0 && nums[start] >= nums[start + 1]) {
            start--;
        }

        if (start >= 0) {
            int j = nums.length - 1;
            while (nums[start] >= nums[j]) {
                j--;
            }
            swap(nums, start, j);
        }

        start++;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
