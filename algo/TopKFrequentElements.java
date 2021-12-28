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