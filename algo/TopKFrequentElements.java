import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentElements {
    // Approach 1: Bucket sort (My version)
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= max; ++i) {
            buckets.add(new ArrayList<>());
        }

        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> listNums = buckets.get(i);
            for (int n : listNums) {
                if (index < res.length) {
                    res[index++] = n;
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
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