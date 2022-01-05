import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MaximumUnitsonaTruck {

    // Approach 1: Using Array Sort
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

    // Approach 2: Using PriorityQueue
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new SortBox());
        q.addAll(Arrays.asList(boxTypes));
        int res = 0;
        while (!q.isEmpty()) {
            int[] type = q.poll();
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

    // Approach 3: BruteForse
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int maximumUnits3(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        int remainingTruckSize = truckSize;
        while (remainingTruckSize > 0) {
            int maxUnitBoxIndex = findMaxUnitBox(boxTypes);
            // check if all boxes are used
            if (maxUnitBoxIndex == -1)
                break;
            // find the box count that can be put in truck
            int boxCount = Math.min(remainingTruckSize, boxTypes[maxUnitBoxIndex][0]);
            unitCount += boxCount * boxTypes[maxUnitBoxIndex][1];
            remainingTruckSize -= boxCount;
            // mark box with index maxUnitBoxIndex as used
            boxTypes[maxUnitBoxIndex][1] = -1;
        }
        return unitCount;
    }

    public int findMaxUnitBox(int[][] boxTypes) {
        int maxUnitBoxIndex = -1;
        int maxUnits = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][1] > maxUnits) {
                maxUnits = boxTypes[i][1];
                maxUnitBoxIndex = i;
            }
        }
        return maxUnitBoxIndex;
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