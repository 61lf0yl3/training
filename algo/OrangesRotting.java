class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int freshOranges = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    int[] temp = {r,c}; 
                    q.add(temp);
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        
        
        int[] sortLevel = {-1, -1};
        q.add(sortLevel);

        int minutes = -1;
        
        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (q.size() > 0) {
            int[] head = q.remove();
            
            if (head[0] == -1) {
                minutes++;
                if (q.size() > 0) {
                    q.add(sortLevel);   
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int new_r = head[0] + dir[i][0];
                    int new_c = head[1] + dir[i][1];
                    if (new_r >= 0 && new_c >= 0 && new_r < grid.length && new_c < grid[0].length) {
                        if (grid[new_r][new_c] == 1) {
                            grid[new_r][new_c] = 2;
                            freshOranges--;
                        
                            int[] temp = {new_r, new_c};
                            q.add(temp);
                        }
                    }
                }    
            }
        }
        if (freshOranges == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}