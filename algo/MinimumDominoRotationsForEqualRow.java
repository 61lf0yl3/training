class MinimumDominoRotationsForEqualRow {
    // 1007. Minimum Domino Rotations For Equal Row

    // Approach 4: Greedy
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int swapsTops = check(tops, bottoms, tops[0]);
        if (swapsTops != -1 || tops[0] == bottoms[0]) {
            return swapsTops;
        } else {
            return check(tops, bottoms, bottoms[0]);
        }
    }

    private int check(int[] tops, int[] bottoms, int target) {
        int swapsTops = 0;
        int swapsBottoms = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                swapsTops++;
            } else if (bottoms[i] != target) {
                swapsBottoms++;
            }
        }
        return Math.min(swapsTops, swapsBottoms);
    }
}