import java.util.Arrays;

class Problem6 {
    public static void main(String[] args) {
        int[] num = {};
        int target = 9;
        //System.out.println(isDecr5(num));
        //System.out.println(findLast(num, target));
        System.out.println(Arrays.toString(afterLast(num, target)));
    }

    public static boolean isDecr5(int[] nums) {
        boolean decr5 = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] - 5 != nums[i + 1]) {
               return false;
            }
       }
       return decr5;
    }

    public static int findLast(int[] nums, int target) {
        int index = -1;
        for ( int i= 0; i<nums.length; i++) {
            if (nums[i] == target) {
                index = i;
            }
        }
        return index;
    }

    public static int[] afterLast(int[] nums, int target) {
        int index = findLast(nums, target);
        if (index == -1) {
            return nums;
        }
        int newLength = nums.length - (index+1);
        int[] res = new int[newLength];
        int newIndex = 0;
        for (int i=index+1;i<nums.length; i++) {
            res[newIndex] = nums[i];
            newIndex++;
        }
        return res; 
    }
}