class Solution {
    
    //My solution O(row*column) DFS recursive
    boolean[][] seen;
    public static int counter;
    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                dfs(grid, row, column);
                if (counter > max) {
                    max = counter;
                }
                counter = 0;
            }
        }
        return max;
    }
    
    public void dfs(int[][] grid, int row, int column) {
        if (row < 0  || row >= grid.length || column < 0 || column >= grid[0].length || seen[row][column] || grid[row][column] == 0) {
            return;
        }
        if (grid[row][column] == 1) {
            counter++;
            seen[row][column] = true;
            dfs(grid, row+1, column);
            dfs(grid, row-1, column);
            dfs(grid, row, column+1);
            dfs(grid, row, column-1);
        }
        return;
    }

	// leetcode neat same method
	public int maxAreaOfIsland2(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    max = Math.max(util(grid,i,j),max);
                }
            }
        }
        return max;
    }
    public static int util(int[][] grid,int i,int j){
        if(i>=0 && j>=0 && i<grid.length && j< grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + util(grid,i-1,j) + util(grid,i,j-1) + util(grid,i+1,j) + util(grid,i,j+1);
        }
        return 0;
    }
}