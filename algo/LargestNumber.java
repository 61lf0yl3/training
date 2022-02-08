import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsString = new String[n];
        for (int i = 0; i < n; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsString, new SortNum());

        if (numsString[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(numsString[i]);
        }
        return res.toString();
    }
}

class SortNum implements Comparator<String> {
    public int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);
    }
}