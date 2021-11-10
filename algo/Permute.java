import java.util.ArrayList;
import java.util.List;

class Permute {
    
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    //Approach 1: Backtracking
    //Time complexity: O(N×N!)
    //Space complexity : O(N!) 
    public void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int start) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                int temp2 = nums[start];
                nums[start] = nums[i];
                nums[i] = temp2;
                backtrack(nums, res, temp, start+1);
                nums[i] = nums[start];
                nums[start] = temp2;
                temp.remove(temp.size()-1);
            }
        }
    } 
}