import java.util.Arrays;

class SortColors {
    // Approach 1: One Pass
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int curr = 0;

        while (curr <= high) {
            if (nums[curr] == 0) {
                nums[curr++] = nums[low];
                nums[low++] = 0;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[high];
                nums[high--] = 2;
            } else {
                curr++;
            }
        }
    }

    // Approach 3: Buble Sort
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public void sortColors3(int[] nums) {
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

    // Approach 2: Sort
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public void sortColors2(int[] nums) {
        Arrays.sort(nums);
    }
}