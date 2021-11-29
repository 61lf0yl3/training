import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int len = 0; len <= nums.length; len++) {
            backtrack(nums, res, new LinkedList<Integer>(), len, 0);
        }
        return res;
    }
    
    //Appraoch #1: Backtraking
    //Time Complexity: O(N*N^2)
    //Space Complexity: O(N)
    public void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> comb, int len, int start) {
        if (comb.size() == len) {
                res.add(new ArrayList<>(comb));
                return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) {  //??
                continue;
                }
                    comb.add(nums[i]);
                    backtrack(nums, res, comb, len, i+1);
                    comb.removeLast();
            }
        }
    }

    //Approach 2: Cascading (Iterative)
    //Time Complexity: O(N*N^2)
    //Space Complexity: O(logN)
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        int subsetSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int startingIndex = (i >= 1 && nums[i] == nums[i - 1]) ? subsetSize : 0;
            // subsetSize refers to the size of the subset in the previous step. This value also indicates the starting index of the subsets generated in this step.
            subsetSize = subsets.size();
            for (int j = startingIndex; j < subsetSize; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}