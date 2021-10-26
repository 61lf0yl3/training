import java.beans.Visibility;

public class FloodFill {

    static int[][] visibleField = { { -1, -1, -1, -1, -1, -1, -1, -1 }, 
                                    { -1, -1, -1, -1, -1, -1, -1, -1 },
                                    { -1, -1, -1, -1, -1, -1, -1, -1 }, 
                                    { -1, -1, -1, -1, -1, -1, -1, -1 }, 
                                    { -1, -1, -1, -1, -1, -1, -1, -1 },
                                    { -1, -1, -1, -1, -1, -1, -1, -1 }, 
                                    { -1, -1, -1, -1, -1, -1, -1, -1 }, 

                                    { -1, -1, -1, -1, -1, -1, -1, -1 } };
    static boolean[][] mineField = { { false, false, false, true, true, false, false, false },
                                     { false, true, false, false, false, false, false, false },
                                     { false, false, false, false, false, true, false, true },
                                     { false, false, false, true, false, false, true, false },
                                     { true, false, false, false, false, false, false, false },
                                     { false, false, false, false, false, false, false, false },
                                     { false, false, false, false, false, false, false, false },
                                     { true, false, false, false, false, false, false, true } };
    static int MINE_GUESS = -2;


    static boolean[][] seen = new boolean[mineField.length][mineField[0].length];

    public static void main(String[] args) {
        floodFill(3, 3);
        print();
        // print(mineField);
    }

    public static int numAdjacentMines(int row, int col) {
        int res = 0;

        // all 8 possible adjacent
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int i = 0; i < directions.length; i++) {
            int new_r = row + directions[i][0];
            int new_c = col + directions[i][1];
            if (new_r >= 0 && new_c >= 0 && new_r < mineField.length && new_c < mineField[0].length) {
                if (mineField[new_r][new_c] == true) {
                    res++;
                }
            }
        }
        return res;
    }

    private static void floodFill(int row, int col) {
        if (visibleField[row][col] >=0 && visibleField[row][col] <= 8) {
            return;
        }
        int status = numAdjacentMines(row, col);
        if (visibleField[row][col] != MINE_GUESS) {
            visibleField[row][col] = status;
        }
        if (status >= 1 && status <= 8) {
            return;
        }
        if (status == 0) {
            //seen[row][col] = true;
            if (row >= 1) {
                floodFill(row - 1, col);
            }
            if (col >= 1) {
                floodFill(row, col - 1);
            }
            if (row + 1 < mineField.length) {
                floodFill(row + 1, col);
            }
            if (col + 1 < mineField[0].length) {
                floodFill(row, col + 1);
            }
            if (row >= 1 && col >= 1) {
                floodFill(row - 1, col - 1);
            }
            if (row + 1 < mineField.length && col + 1 < mineField[0].length) {
                floodFill(row + 1, col + 1);
            }
            if (row + 1 < mineField.length && col >= 1) {
                floodFill(row + 1, col - 1);
            }
            if (row >= 1 && col + 1 < mineField[0].length) {
                floodFill(row - 1, col + 1);
            }
        }
    }

    public static void print() {
        for (int r = 0; r < visibleField.length; r++) {
            for (int c = 0; c < visibleField[0].length; c++) {
                System.out.print(visibleField[r][c]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}