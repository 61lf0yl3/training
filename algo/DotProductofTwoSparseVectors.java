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

// Approach 2: Non-efficient Array Approach
// Time complexity : O(N) for both constructing the sparse vector and
// calculating the dot product.
// Space complexity : O(1) for constructing the sparse vector as we simply save
// a reference to the input array and O(1)for calculating the dot product.
class SparseVector2 {

    private int[] array;

    SparseVector2(int[] nums) {
        array = nums;
    }

    public int dotProduct(SparseVector2 vec) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            result += array[i] * vec.array[i];
        }
        return result;
    }
}

// Approach 3: Index-Value Pairs
// Time complexity : O(N) for both constructing the sparse vector and
// calculating the dot product.
// Space complexity : O(1) for constructing the sparse vector as we simply save
// a reference to the input array and O(1)for calculating the dot product.
class SparseVector3 {

    List<int[]> pairs;

    SparseVector3(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[] { i, nums[i] });
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector3 vec) {
        int result = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) {
            if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            } else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) {
                q++;
            } else {
                p++;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);