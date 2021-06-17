import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DotProductofTwoSparseVectors {
    public static void main(String[] args) {

    }
}

// Approach 1: Hash Set
// Time complexity : O(N) for creating the Hash Map;
// O(L)for calculating the dot product.
// Space complexity : O(L) for creating the Hash Map, as we only store elements
// that are non-zero, O(1) for calculating the dot product.
class SparseVector {
    Map<Integer, Integer> m;

    SparseVector(int[] nums) {
        m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                m.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ret = 0;
        for (Integer key : m.keySet()) {
            if (vec.m.containsKey(key)) {
                int prod = m.get(key) * vec.m.get(key);
                ret += prod;
            }
        }
        return ret;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);