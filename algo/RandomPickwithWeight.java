import java.util.Random;

class RandomPickwithWeight {
    int[] w;
    int[] prefixSums;
    Random r;
    int prefixSum;

    // Approach 1: Prefix Sums with Binary Search
    // Time complexity : RandomPickwithWeight() O(N)
    // pickIndex() O(logN)
    // Space complexity : RandomPickwithWeight() O(N)
    // pickIndex() O(1)
    public RandomPickwithWeight(int[] w) {
        this.w = w;
        r = new Random();
        prefixSums = new int[w.length];
        prefixSum = 0;
        for (int i = 0; i < w.length; i++) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
    }

    public int pickIndex() {
        int generated = r.nextInt(prefixSum);
        return binarySearch(generated + 1);
    }

    private int binarySearch(int target) {
        int low = 0;
        int high = prefixSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target == prefixSums[mid]) {
                return mid;
            } else if (target > prefixSums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Approach 2: Prefix Sums
    // Time complexity : RandomPickwithWeight() O(N)
    // pickIndex() O(N)
    // Space complexity : RandomPickwithWeight() O(N)
    // pickIndex() O(1)
    public int pickIndex2() {
        int generated = r.nextInt(prefixSum) + 1;
        int index = 0;
        for (int i = 0; i < prefixSums.length; i++) {
            if (prefixSums[i] > generated) {
                index = i;
                break;
            }
        }
        return index;
    }

    // Approach 1: Prefix Sums with Binary Search
    // Time complexity : RandomPickwithWeight() O(N)
    // pickIndex() O(logN)
    // Space complexity : RandomPickwithWeight() O(N)
    // pickIndex() O(1)
    public int pickIndex3() {
        int target = r.nextInt(prefixSum) + 1;
        int low = 0;
        int high = prefixSums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > prefixSums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */