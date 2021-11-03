class updateMatrix {

    // Using BFS
    // Time complexity: O(r⋅c)
    // Space complexity: O(r⋅c)
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }        
        Queue<Integer> q = new LinkedList<>();
        for (int r= 0; r< mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if ( mat[r][c] == 0 ) {
                    int[] temp = {r,c};
                    q.add(temp);
                } else {
                    mat[r][c] = Integer.MAX_VALUE;
                }
            }
        }
            
        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            
        while (q.size() != 0) {
            int[] head = q.remove();
            for (int i = 0; i < 4; i++) {
                int new_r = head[0] + dir[i][0];
                int new_c = head[1] + dir[i][1];
                if (new_r >= 0 && new_c >= 0 && new_r < mat.length && new_c < mat[0].length) {
                    if (mat[new_r][new_c] > mat[head[0]][head[1]] + 1) {
                        mat[new_r][new_c] = mat[head[0]][head[1]] + 1;
                        int[] temp = {new_r, new_c};
                        q.add(temp);
                    }
                }
            }
        }
        return mat;
    }

    // Dynamic Programming Approach
    // Time complexity: O(r⋅c)
    // Space complexity: O(1))
    public int[][] updateMatrix2(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        if (rows == 0) {
            return mat;
        }        
        
        for (int r= 0; r< rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (mat[r][c] != 0) {
                    mat[r][c] = rows+columns;
                }
                if (r > 0) {
                    mat[r][c] = Math.min(mat[r][c], mat[r-1][c]+1);
                }
                if (c > 0) {
                    mat[r][c] = Math.min(mat[r][c], mat[r][c-1]+1);
                }
            }
        }
        
        for (int r = rows-1; r>= 0; r--) {
            for (int c = columns-1; c >= 0; c--) {
                if (r < rows - 1) {
                    mat[r][c] = Math.min(mat[r][c], mat[r+1][c]+1);
                }
                if (c < columns - 1) {
                    mat[r][c] = Math.min(mat[r][c], mat[r][c+1]+1);
                }
            }
        }
            
        return mat;
    }
}