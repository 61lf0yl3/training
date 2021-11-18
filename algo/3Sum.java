import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    //15. 3Sum

    //Time Complexity:O(N^2)
    //Space Complexity: O(logN) to O(N). Depending on the implementation of the sorting algorithm.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index< nums.length; index++) {
            if (nums[index] > 0) {
                break;
            }
            if (index == 0 || nums[index - 1] != nums[index]) {
                TwoSum2(nums,index, res); // TwoSum(nums,index, res); we can call 
            }
        }
        return res;
    }
    
    //Approach 1: Two Pointers
    //Time Complexity:O(N^2)
    //Space Complexity: O(logN) to O(N). Depending on the implementation of the sorting algorithm.
    public void TwoSum2(int[] nums, int index, List<List<Integer>> res) {
        int target = nums[index];
        int low = index+1;
        int high = nums.length-1;
        while (low < high) {
            int sum = nums[low]+nums[high];
            if (sum+target==0) {
                res.add(Arrays.asList(target, nums[low], nums[high]));
                high--;
                low++;
                while (low < high && nums[low] == nums[low - 1])
                    low++;
            } else if (sum + target > 0) {
                high--; 
            } else {
                low++;
            }
        }
    }

    //Approach 1: Hashset
    //Time Complexity:O(N^2)
    //Space Complexity:  O(N) for the hashset.
    public void TwoSum(int[] nums, int index, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<>();
        for (int i = index +1; i < nums.length; i++) {
            int compliment = -nums[index] - nums[i];
            if (seen.contains(compliment)) {
                res.add(Arrays.asList(nums[index], nums[i], compliment));
                while (i<nums.length-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
            seen.add(nums[i]);
        }
    }
    
    //Approach 3: "No-Sort"
    //Time Complexity:O(N^2)
    //Space Complexity:  O(N) for the hashset.
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}