import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

class Permutation2 {
    //Approach 1: Backtracking with Groups of Numbers and Set
    //Time Complexity: O(N*N!)
    //Space Complexity: O(N)
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

    //Approach 2: Backtracking with Groups of Numbers (leetcode version)
    //Time Complexity: O(N*N!)
    //Space Complexity: O(N)
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }
}