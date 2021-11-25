import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;

class Permutation2 {
    //Approach 1: Backtracking with Groups of Numbers and Set
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<LinkedList<Integer>> m = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, m, new LinkedList<>(), 0); 
        for (LinkedList<Integer> comb : m) {
            res.add(new ArrayList<>(comb));
        }
        return res;
    }
    
    public void backtrack(int[] nums, Set<LinkedList<Integer>> res, LinkedList<Integer> comb, int start) { 
       if (comb.size()==nums.length && !res.contains(comb) ) {
           res.add(new LinkedList<>(comb));
       } else {
           for (int i = start; i < nums.length; i++) { 
               comb.add(nums[i]);
               int temp = nums[start];
               nums[start] = nums[i];
               nums[i] = temp;
               backtrack(nums, res, comb, start+1);
               nums[i] = nums[start];
               nums[start] = temp;
               comb.removeLast();
           }
       }
        
    }
}