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

    
}