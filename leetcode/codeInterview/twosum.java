import java.util.HashMap;
import java.util.Map;

class TwoSum {
    
    // HashMap
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
    
    
    // HashMap
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment) && map.get(compliment) != i ) {
                return new int[] { i, map.get(compliment) };
            }
        }
        return null;
    }
    
    // bruteforce
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i=0; i< nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }
}