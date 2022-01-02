import java.util.Arrays;

class MinimumMovestoEqualArrayElements {
    // 453. Minimum Moves to Equal Array Elements

    // Approach 3: Using Sorting
    // Time complexity : O(NlogN)
    // Space complexity : O(1)
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            res += nums[i] - nums[0];
        }
        return res;
    }

    // Approach 3: Brute Force (TLE)
    // Time complexity : O(N^2)
    // Space complexity : O(1)
    public int minMoves3(int[] nums) {
        int res = 0;
        int max = findMax(nums);
        int min = findMin(nums);
        while (min < max) {
            res++;
            int counter = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max && counter == 1) {
                    counter--;
                    continue;
                }
                nums[i]++;
            }
            max = findMax(nums);
            min = findMin(nums);
        }
        return res;
    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}