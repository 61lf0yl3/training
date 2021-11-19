import java.util.ArrayList;
import java.util.List;

class IntervalListIntersections {

    //Approach 1: Merge Intervals
    //Time Complexity: O(N+M)
    //Space Complexity: O(N+M)
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length ) {
            int low = Math.max(firstList[i][0],secondList[j][0]);
            int high = Math.min(firstList[i][1],secondList[j][1]);
            
            if (low<=high) {
                res.add(new int[]{low,high});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}