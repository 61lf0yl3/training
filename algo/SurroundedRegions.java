import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class SurroundedRegions {
    //130. Surrounded Regions

    //Approach #1: DFS
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public void solve(char[][] board) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        List<int[]> border = new ArrayList<>();
        
        for (int r = 0; r < board.length; r++) {
            border.add(new int[]{r, 0});
            border.add(new int[]{r, board[0].length-1});
        }
        for (int c = 0; c < board[0].length; c++) {
            border.add(new int[]{0,c});
            border.add(new int[]{board.length-1,c});
        }
        
        for (int i = 0; i<border.size(); i++) {
            int[] temp = border.get(i);
            dfs(board, seen,temp[0],temp[1]);
        }
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (!seen[r][c] && board[r][c]=='O') {
                    board[r][c] = 'X';
                }        
            }
        }
    }
    
    
    public void dfs(char[][] board, boolean[][] seen, int r, int c) {
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || seen[r][c] || board[r][c]=='X') {
            return;
        } else {
            seen[r][c] = true;
            dfs(board, seen, r,c-1);
            dfs(board, seen, r-1,c);
            dfs(board, seen, r,c+1);
            dfs(board, seen, r+1,c);
        }
    }

    int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};
    public void bfs(char[][] board, boolean[][] seen, int r, int c) {
        Queue<int[]>  q = new LinkedList<>();
        q.add(new int[]{r,c});
        seen[r][c]=true;
        while (!q.isEmpty()) {
            int[] cell = q.remove();
            
            for (int i=0; i<direction.length;i++ ) {
                int newR = cell[0]+direction[i][0];
                int newC = cell[1]+direction[i][1];
                if (newR < board.length && newC < board[0].length && newR >= 0 && newC >= 0 && !seen[newR][newC] && board[newR][newC]=='O') {
                    seen[newR][newC]=true;
                    q.add(new int[]{newR,newC});
            }
           
            }
        }
    }
}