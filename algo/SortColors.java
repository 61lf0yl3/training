import java.util.Arrays;

class SortColors {
    // Approach 1: Buble Sort
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // Approach 1: Sort
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public void sortColors2(int[] nums) {
        Arrays.sort(nums);
    }

    // Approach 1: One Pass
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public void sortColors3(int[] nums) {
        int p0 = 0;
        int curr = 0;
        int p2 = nums.length - 1;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                nums[curr++] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[p2];
                nums[p2--] = 2;
            } else {
                curr++;
            }
        }
    }
}