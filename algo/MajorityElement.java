import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class MajorityElement {

    // Approach 1: Iterative Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;
        int maxFreq = 0;
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            if (m.get(num) > maxFreq) {
                maxFreq = m.get(num);
                max = num;
            }
        }
        return max;
    }

    // Approach 1: Using Sorting
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int majorityElement2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    // Approach 3: Using Randomization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement3(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}