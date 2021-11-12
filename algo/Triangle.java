import java.util.Collections;
import java.util.List;

class Triangle {
    //Approach 1: Dynamic Programming (Bottom-up, my verison)
    //Time Complexity:O(n^2)
    //Space Complexity: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        if (triangle.size() == 1){
            min = triangle.get(0).get(0);
        }
        int[][] cost = new int[triangle.size()][triangle.size()]; 
        cost[0][0] =  triangle.get(0).get(0);
        for (int r = 1; r < triangle.size(); r++) {
            for (int c = 0; c <= r; c++) {
                if (c == 0 ) {
                    cost[r][c] = triangle.get(r).get(c) + cost[r-1][c];
                } else if (c == r) {
                    cost[r][c] = triangle.get(r).get(c) + cost[r-1][c-1];
                } else {
                    cost[r][c] = triangle.get(r).get(c) + Math.min(cost[r-1][c], cost[r-1][c-1]);
                }
                if (r == triangle.size() -1 && min > cost[r][c]) {
                    min = cost[r][c];
                }
            }
        }
        
        return min;
    }

    //Approach 1: Dynamic Programming (Bottom-up)
    //Time Complexity:O(n^2)
    //Space Complexity: O(n)
    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int r = 1; r < triangle.size(); r++) {
            for (int c = 0; c <= r; c++) {
                if (c == 0 ) {
                    triangle.get(r).set(c, triangle.get(r).get(c) + triangle.get(r-1).get(c));
                } else if (c == r) {
                    triangle.get(r).set(c, triangle.get(r).get(c) + triangle.get(r-1).get(c-1));
                } else {
                    triangle.get(r).set(c, triangle.get(r).get(c) + Math.min(triangle.get(r-1).get(c), triangle.get(r-1).get(c-1)));
                }
            }
        }
        
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}