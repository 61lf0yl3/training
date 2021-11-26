import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class CombinationSum {
    //Approach 1: Backtracking
    //Time Complexity: O(N^(T/M+1))
    //Space Complexity: O(N^T/M)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new LinkedList<Integer>(), 0, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, int target,
                          List<List<Integer>> res, 
                          LinkedList<Integer> comb, int sum, int start) {
        if (sum>= target) {
            if (sum == target) {
                res.add(new ArrayList<>(comb));
            }
        } else {
            for (int i = start; i < candidates.length; i++) {
                comb.add(candidates[i]);
                backtrack(candidates, target, res, comb, sum + candidates[i], i);
                comb.removeLast();
            }
        }
    }
}