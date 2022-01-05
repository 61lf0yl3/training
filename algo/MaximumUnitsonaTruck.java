import java.util.Arrays;
import java.util.Comparator;

class MaximumUnitsonaTruck {

    // Approach 2: Using Array Sort
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new SortBox());
        int res = 0;
        for (int[] type : boxTypes) {
            if (truckSize > type[0]) {
                truckSize -= type[0];
                res += type[0] * type[1];
            } else {
                res += truckSize * type[1];
                truckSize = 0;
                return res;
            }
        }
        return res;
    }

}

class SortBox implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        int ret = b[1] - a[1];
        if (ret != 0) {
            return ret;
        }
        return b[0] - a[0];
    }
}