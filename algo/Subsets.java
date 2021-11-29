import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


class Subsets {
    //78. Subsets

    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        cascading(nums, res);
        // for (int len = 0; len <= nums.length; len++) {
        //     backtrack(nums, res, new LinkedList<Integer>(), len, 0);
        // }
        return res;
    }
    
    //Appraoch #1: Backtraking
    //Time Complexity: O(N*N^2)
    //Space Complexity: O(N*N^2)
    public void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> comb, int len, int start) {
        if (len == comb.size()) {
            res.add(new ArrayList(comb));
        } else {
            for (int i = start; i<nums.length; i++ ) {
                comb.add(nums[i]);
                backtrack(nums, res, comb, len, i+1);
                comb.removeLast();
            }
        }
    }

    //Appraoch #1: Cascading
    //Time Complexity: O(N*N^2)
    //Space Complexity: O(N*N^2)
    public List<List<Integer>> cascading(int[] nums, List<List<Integer>> res) {
        for (int num : nums) {
            int size = res.size();
            for (int i=0; i<size;i++) {
                List<Integer> temp = new LinkedList(res.get(i));
                temp.add(num);
                res.add(new ArrayList(temp));
            }
        }
        return res;
    }

    //Appraoch #1: Lexicographic (Binary Sorted) Subsets
    //Time Complexity: O(N*N^2)
    //Space Complexity: O(N*N^2)
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
    
        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {
          // generate bitmask, from 0..00 to 1..11
          String bitmask = Integer.toBinaryString(i).substring(1);
    
          // append subset corresponding to that bitmask
          List<Integer> curr = new ArrayList();
          for (int j = 0; j < n; ++j) {
            if (bitmask.charAt(j) == '1') curr.add(nums[j]);
          }
          output.add(curr);
        }
        return output;
      }
}