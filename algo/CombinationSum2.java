import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class CombinationSum2 {

    //Approach 1: Backtracking
    //Time Complexity: O(2^N)
    //Space Complexity: O(N)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new LinkedList<Integer>(), 0, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> comb, int sum, int start) {
        if (sum>=target) {
            if (sum==target) {
                res.add(new ArrayList(comb));
            }
        } else {
            for (int i=start; i<candidates.length; i++) {
                if (i !=start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                comb.add(candidates[i]);
                backtrack(candidates, target, res, comb, sum+candidates[i], i+1);
                comb.removeLast();
            }
        }
    }
}

//leetcode solution
class CombinationSum22 {
    //Approach 1: Backtracking
    //Time Complexity: O(2^N)
    //Space Complexity: O(N)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // container to hold the final combinations
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (counter.containsKey(candidate))
                counter.put(candidate, counter.get(candidate) + 1);
            else
                counter.put(candidate, 1);
        }

        // convert the counter table to a list of (num, count) tuples
        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[]{key, value});
        });

        backtrack(comb, target, 0, counterList, results);
        return results;
    }

    private void backtrack(LinkedList<Integer> comb,
                           int remain, int curr,
                           List<int[]> counter,
                           List<List<Integer>> results) {

        if (remain <= 0) {
            if (remain == 0) {
                // make a deep copy of the current combination.
                results.add(new ArrayList<Integer>(comb));
            }
            return;
        }

        for (int nextCurr = curr; nextCurr < counter.size(); ++nextCurr) {
            int[] entry = counter.get(nextCurr);
            Integer candidate = entry[0], freq = entry[1];

            if (freq <= 0)
                continue;

            // add a new element to the current combination
            comb.addLast(candidate);
            counter.set(nextCurr, new int[]{candidate, freq - 1});

            // continue the exploration with the updated combination
            backtrack(comb, remain - candidate, nextCurr, counter, results);

            // backtrack the changes, so that we can try another candidate
            counter.set(nextCurr, new int[]{candidate, freq});
            comb.removeLast();
        }
    }
}