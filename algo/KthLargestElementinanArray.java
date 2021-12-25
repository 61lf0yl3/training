import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElementinanArray {
    // 215. Kth Largest Element in an Array

    // Approach 1: PriorityQueue
    // Time Complexity: O(NlogN)
    // Space Complexity: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            qp.add(nums[i]);
            if (qp.size() > k) {
                qp.remove();
            }
        }
        return qp.poll();
    }

    // Approach 2: Quickselect (same idea as QuickSort)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findKthLargest2(int[] nums, int k) {
        quickSort(nums, k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int k, int from, int to) {
        if (from >= to) {
            return;
        }
        int p = partition(nums, from, to);
        if (nums.length - k >= p + 1) {
            quickSort(nums, k, p + 1, to);
        } else {
            quickSort(nums, k, from, p);
        }

    }

    private int partition(int[] nums, int from, int to) {
        int pivot = nums[from];
        int i = from - 1;
        int j = to + 1;
        while (i < j) {
            i++;
            while (nums[i] < pivot) {
                i++;
            }
            j--;
            while (nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return j;
    }

    // Approach 1: PriorityQueue with 2 loops
    // Time Complexity: O(NlogN)
    // adding an element in a heap of size k is O(logk)
    // Space Complexity: O(k)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            qp.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            res = qp.remove();
        }
        return res;
    }

    // Approach 3: Sort
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public int findKthLargest3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}