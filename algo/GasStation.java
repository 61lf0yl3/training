class GasStation {

    // Approach 2: Brute Force
    // Time complexity : O(N^2)
    // Space complexity : O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int tank = 0;
            for (int j = i; j < i + n; j++) {
                int index = j % n;
                tank = tank + gas[j % n] - cost[j % n];
                if (tank < 0) {
                    break;
                }
            }
            if (tank >= 0) {
                return i;
            }
        }
        return -1;
    }
}