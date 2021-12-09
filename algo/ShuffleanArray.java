import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//384. Shuffle an Array

// Approach 1: Brute Force
// Time Complexity: O(N^2)
// Space Complexity: O(N)
class ShuffleanArray {

    private int[] nums;
    private int[] shuffeled;
    private Random shuffler;

    public ShuffleanArray(int[] nums) {
        this.nums = nums.clone();
        shuffeled = new int[nums.length];
        shuffler = new Random();
    }

    public int[] reset() {
        shuffeled = nums;
        nums = nums.clone();
        return nums;
    }

    public int[] shuffle() {
        List<Integer> aux = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            aux.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int randomIndex = shuffler.nextInt(aux.size());
            shuffeled[i] = aux.get(randomIndex);
            aux.remove(randomIndex);
        }
        return shuffeled;
    }
}

// Approach 2: Fisher-Yates Algorithm
// swapping elements around within the array itself
// Time Complexity: O(N^2)
// Space Complexity: O(N)
class ShuffleanArray2 {

    private int[] nums;
    private int[] shuffeled;
    private Random shuffler;

    public ShuffleanArray2(int[] nums) {
        this.nums = nums.clone();
        shuffeled = new int[nums.length];
        shuffler = new Random();
    }

    public int[] reset() {
        shuffeled = nums;
        nums = nums.clone();
        return nums;
    }

    public int[] shuffle() {
        int[] temp = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int randomIndex = shuffler.nextInt(temp.length - i);
            shuffeled[i] = temp[randomIndex];
            int temp1 = temp[randomIndex];
            temp[randomIndex] = temp[temp.length - i - 1];
            temp[temp.length - i - 1] = temp1;
        }
        return shuffeled;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */