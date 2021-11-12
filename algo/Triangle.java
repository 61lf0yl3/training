import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    //Approach 2: Dynamic Programming (Bottom-up)
    //Time Complexity:O(n^2)
    //Space Complexity: O(1)
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


    //Approach 3: Dynamic Programming (Bottom-up: Flip Triangle Upside Down)
    //Time Complexity:O(n^2)
    //Space Complexity: O(1)    
    public int minimumTotal3(List<List<Integer>> triangle) {
        for (int r = triangle.size()-2; r >=0; r--) {
            for (int c = 0; c <= r; c++) {
                triangle.get(r).set(c, triangle.get(r).get(c) + Math.min(triangle.get(r+1).get(c), triangle.get(r+1).get(c+1)));
            }
        }
        
        return triangle.get(0).get(0);
    }

    //Approach 4: Memoization (Top-Down)
    ////Time Complexity:O(n^2)
    //Space Complexity: O(n^2)    
    private Map<String, Integer> memoTable;
    private List<List<Integer>> triangle;
    
    private int minPath(int row, int col) {
        String params = row + ":" + col;
        if (memoTable.containsKey(params)) {
            return memoTable.get(params);
        } 
        int path = triangle.get(row).get(col);
        if (row < triangle.size() - 1) {
            path += Math.min(minPath(row + 1, col), minPath(row + 1, col + 1));
        }
        memoTable.put(params, path);
        return path;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        memoTable = new HashMap<>();
        return minPath(0, 0);
    }
}