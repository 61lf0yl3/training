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

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int swapsTops = checkTops(tops, bottoms, tops[0]);
        int swapsBottoms = checkBottoms(tops, bottoms, bottoms[0]);
        if (swapsTops == -1 && swapsBottoms == -1) {
            return -1;
        } else if (swapsTops != -1 && swapsBottoms != -1) {
            return Math.min(swapsTops, swapsBottoms);
        } else if (swapsTops != -1) {
            return swapsTops;
        } else {
            return swapsBottoms;
        }
    }

    private int checkTops(int[] tops, int[] bottoms, int target) {
        int swaps = 0;
        for (int i = 1; i < tops.length; i++) {
            if (tops[i] == target) {
                continue;
            } else if (bottoms[i] == target) {
                swaps++;
            } else {
                return -1;
            }
        }
        return Math.min(swaps, tops.length - swaps);
    }

    // Smth wrong
    private int checkBottoms(int[] tops, int[] bottoms, int target) {
        int swaps = 0;
        for (int i = 1; i < bottoms.length; i++) {
            if (bottoms[i] == target) {
                continue;
            } else if (tops[i] == target) {
                swaps++;
            } else {
                return -1;
            }
        }
        return Math.min(swaps, bottoms.length - swaps);
    }
}