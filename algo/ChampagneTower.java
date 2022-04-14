class ChampagneTower {
    // 799. Champagne Tower

    // Approach 1: Simulation
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] pyramid = new double[query_row + 1][query_row + 1];
        pyramid[0][0] = poured;
        for (int r = 0; r < query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double remain = (pyramid[r][c] - 1) / 2.0;
                if (remain > 0) {
                    pyramid[r + 1][c] += remain;
                    pyramid[r + 1][c + 1] += remain;
                }
            }
        }
        return Math.min(1, pyramid[query_row][query_glass]);
    }
}