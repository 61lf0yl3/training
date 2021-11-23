import java.util.Queue;
import java.util.LinkedList;

class NumberofProvinces {

    //mysolution
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (isConnected[r][c] == 1) {
                    res++;
                    dfs(isConnected, r, c);
                }
            }
        }
        
        return res;
    }
    public void dfs(int[][] isConnected, int r, int c) {
        int n = isConnected.length;
        if (r < 0 || c < 0 || r >=n || c >=n || isConnected[r][c] == 0 ) {
            return;
        } else {
            for (int j = 0; j < n; j++) {
                    if (isConnected[r][j] == 1) {
                        isConnected[r][j] = 0;
                        //isConnected[j][r] = 0;
                        dfs(isConnected, j, r);
                    }
            }
        }
    }

    //Optimized my solution
    //Approach #1 Using Depth First Search
    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        int res = 0;
        for (int r = 0; r < n; r++) {
                if (!seen[r]) { 
                    dfs2(isConnected,seen, r);
                    res++;
                }
        }
        
        return res;
    }
    public void dfs2(int[][] isConnected,boolean[]seen, int r) {
        for (int c = 0; c < isConnected.length; c++) {
                if (isConnected[r][c] == 1 && !seen[c]) {
                        seen[c]=true;
                        dfs2(isConnected,seen, c);
                }
        }
    }

    //Approach #2 Using Breadth First Search
    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
    public int findCircleNum3(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}

