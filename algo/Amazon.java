import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Amazon {
    public static void main(String[] args) {
        List<Integer> parcels = new ArrayList<>();
        parcels.addAll(Arrays.asList(10000, 100000, 600000, 999330, 1000000));
        System.out.println(getMinumumCost(parcels, 1000000));
    }

    // Approach 1: Iterative Using HashSet
    // Time Complexity: O(max(k-N, N))
    // Space Complexity: O(N) because we used HashSet;
    public static long getMinumumCost(List<Integer> parcels, int k) {
        // size of input List parcels
        int n = parcels.size();
        // if their size equal then no need to calculate
        if (n == k) {
            return 0;
        }
        // returing variable
        long res = 0;
        // set to keep track existing number
        Set<Integer> set = new HashSet<>();
        // loop over List
        for (int i = 0; i < n; i++) {
            // add to List
            set.add(parcels.get(i));
        }
        // there are alredy n parcels in truck
        // we have k-n
        k = k - n;
        long i = 1;
        while (k > 0) {
            if (!set.contains(i)) {
                res += i;
                k--;
            }
            i++;
        }

        return res;
    }
}
