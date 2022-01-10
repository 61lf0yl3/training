class RangeAddition {
    // 370. Range Addition

    // Approach 1: Range Caching
    // Time Complexity: O(N*M)
    // Space Complexity: O(M)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];

            if (update[1] + 1 < length) {
                res[update[1] + 1] += -update[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            res[i] += sum;
            sum = res[i];
        }
        return res;
    }

    // Approach 2: Brute Force
    // Time Complexity: O(N*M)
    // Space Complexity: O(M)
    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            for (int i = start; i <= end; i++) {
                arr[i] += inc;
            }
        }
        return arr;
    }
}