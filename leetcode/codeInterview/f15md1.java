import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

class f15md1{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.println(sumInts(in));
        //int[] nums = {3, 2, 6, 10};
        System.out.println(readScores(in));
    } 

    public static ArrayList<Integer> readScores(Scanner in) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int score = 0;
        while (score != -1) {
           score = in.nextInt();
           if (score != -1) {
            nums.add(score);
           }
        }
        return nums;
     }
    
    public static int[] divTenFirst(int[] nums) {
        int index = 0;
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (nums[i]%10 == 0) {
                res[index] =nums[i];
                index++;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]%10 != 0) {
                res[index] =nums[i];
                index++;
            }
        }
        return res;
    }

    


    // public static int sumInts(Scanner in) {
    //     System.out.print("Enter numbers when prompted. ");
    //     System.out.println("Use -1 to indicate you are done.");
    //     int num = 0;
    //     int sum = 0;
    //     while (num != -1) {
    //     System.out.print("Enter number (-1 to finish): "); 
    //     num = in.nextInt();
        
    //     if (num > -1) {
    //         sum += num;
    //     }
    //     System.out.println("sum: " + sum);
    //     }
    //     return sum; 
    // }

}