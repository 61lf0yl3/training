class UniquePaths {
    //62. Unique Paths

    // Approach 1: DP
    // Time Complexity: O(M*N) 
    // Space Complexity: O(M*N)
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[n+1][m+1];
        paths[n][m]=1;
        for (int r = 1; r < paths.length; r++) {
            for (int c = 1; c < paths[0].length; c++) {
               if (r==2 && c ==1 || r == 1 && c == 2 || r == 1 && c == 1) {
                   paths[r][c] = 1;
               } else {
                   paths[r][c] = paths[r-1][c]+paths[r][c-1];
               } 
            }
        }
        return paths[n][m];
    }
}