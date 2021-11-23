import java.util.Queue;
import java.util.LinkedList;


class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 ||  grid[grid.length-1][grid.length-1]!= 0) {
             return -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;
        if (grid.length>1) {
            grid[grid.length-1][grid.length-1] =-1;
        }
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int currR = cell[0];
            int currC = cell[1];
            int distance = grid[currR][currC];
            
            for (int i = 0; i<directions.length; i++) {
                int newR = currR+directions[i][0];
                int newC = currC+directions[i][1];
                
                if (newR>=0 && newC>=0 && newR < grid.length && newC < grid[0].length && grid[newR][newC]<=0) {
                    q.add(new int[]{newR, newC});
                    grid[newR][newC] = distance+1;
                }
            }
        }
        return grid[grid.length-1][grid.length-1];
        
    }
}