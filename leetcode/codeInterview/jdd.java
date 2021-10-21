class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    // my version dfs O(n)
    public void dfs(int[][] image, int row, int column, int color, int newColor) {
        if (row < 0  || row >= image.length || column < 0 || column >= image[0].length) {
            return;
        }
        if (image[row][column] == color) {
            image[row][column] = newColor;
            dfs(image, row+1, column, color, newColor);
            dfs(image, row-1, column, color, newColor);
            dfs(image, row, column+1, color, newColor);
            dfs(image, row, column-1, color, newColor);
        }
    }

    // leetcode solution
    public void dfs2(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
}