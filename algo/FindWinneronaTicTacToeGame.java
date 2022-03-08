class Solution {
    // Approach 1: Brute Force
    // Time Complexity: O(N*M)
    // Space Complexity: O(N,M)
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            if (i % 2 == 0) {
                grid[move[0]][move[1]] = 1;
            } else {
                grid[move[0]][move[1]] = 4;
            }
        }
        return check(grid);
    }

    private String check(int[][] grid) {
        int empty = 0;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else {
                    sum += grid[i][j];
                }
            }
            if (sum == 3) {
                return "A";
            } else if (sum == 12) {
                return "B";
            }
        }

        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid[i][j];
            }
            if (sum == 3) {
                return "A";
            } else if (sum == 12) {
                return "B";
            }
        }

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += grid[i][i];
        }
        if (sum == 3) {
            return "A";
        } else if (sum == 12) {
            return "B";
        }

        sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += grid[i][2 - i];
        }
        if (sum == 3) {
            return "A";
        } else if (sum == 12) {
            return "B";
        }

        if (empty > 0) {
            return "Pending";
        }
        return "Draw";
    }
}