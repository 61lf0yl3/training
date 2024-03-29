import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class TopKFrequentElements {
    // Approach 1: Bucket sort (My version)
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, m.get(num));
        }
        ArrayList<ArrayList<Integer>> backet = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            backet.add(new ArrayList<>());
        }

        for (int key : m.keySet()) {
            backet.get(m.get(key)).add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = maxFreq; i >= 0; i--) {
            for (int num : backet.get(i)) {
                if (index < res.length) {
                    res[index++] = num;
                }
            }
        }
        return res;
    }

    // Approach 2: Bucket sort
    // Time complexity : O(NLogK)
    // Space complexity : O(N+K)
    public int[] topKFrequent2(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        // init heap 'the less frequent element first'
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> m.get(a) - m.get(b));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int num : m.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

    // Approach 2: Quickselect (Hoare's selection algorithm)
    // Time complexity : O(N) on average, O(N^2) in the worst case
    // Space complexity : O(N)

    int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public void quickselect(int left, int right, int k_smallest) {
        /*
         * Sort a list within left..right till kth less frequent element
         * takes its place.
         */

        // base case: the list contains only one element
        if (left == right)
            return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent3(int[] nums, int k) {
        // build hash map : character and how often it appears
        count = new HashMap();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num : count.keySet()) {
            unique[i] = num;
            i++;
        }

        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}

// public int[] topKFrequent(int[] nums, int k) {
// if (k == nums.length) {
// return nums;
// }
// Map<Integer, Integer> numToFreq = new HashMap<>();
// for (int i = 0; i < nums.length; i++) {
// numToFreq.put(nums[i], numToFreq.getOrDefault(nums[i],0)+1);
// }
// Map<Integer, []Integer> freqToNum = new HashMap<>();
// for (Map.Entry<Integer,Integer> entry : numToFreq.entrySet()) {
// freqToNum.put(entry.getValue(),entry.getKey());
// }
// int[] freq = new int[freqToNum.size()];
// int index = 0;
// for (int num : freqToNum.keySet()) {
// freq[index++] = num;
// }
// int[] res = new int[k];
// for (int i = 0; i < k; i++) {
// int pivot = freq[i];
// int max = pivot;
// int swapJ = i;
// for (int j = i+1; j < freq.length; j++) {
// if (freq[j] > max) {
// max = freq[j];
// swapJ = j;
// }
// }
// freq[i] = max;
// freq[swapJ] = pivot;

// res[i] = freqToNum.get(max);
// }
// return res;
// }