class ReachingPoints {
    // Approach 1: Exhaustive Search (TLE)
    // Time Complexity: O(2^tx+ty)
    // Space Complexity: O(tx*ty)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        return reachingPoints(sx, sx + sy, tx, ty) || reachingPoints(sx + sy, sx, tx, ty);
    }
}