import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int index = 0; index< nums.length; index++) {
            if (nums[index] > 0) {
                break;
            }
            if (index == 0 || nums[index - 1] != nums[index]) {
                TwoSum(nums,index, res);
            }
        }
        return res;
    }
    
    public void TwoSum(int[] nums, int index, List<List<Integer>> res) {
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
}