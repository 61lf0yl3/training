class GasStation {

    // Approach 1: One pass
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingStaton = 0;
        int totalTank = 0;
        int currTank = 0;
        for (int i = 0; i < gas.length; i++) {
            currTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];

            // If one couldn't get here,
            if (currTank < 0) {
                // Pick up the next station as the starting one.
                startingStaton = i + 1;
                // Start with an empty tank.
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startingStaton : -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += (gas[i] - cost[i]);
            currentTank += (gas[i] - cost[i]);
            if (currentTank < 0) {
                currentTank = 0;
                res = i + 1;
            }
        }
        return totalTank < 0 ? -1 : res;
    }

    // Approach 2: Brute Force (TLE)
    // Time complexity : O(N^2)
    // Space complexity : O(1)
    public int canCompleteCircuit2(int[] gas, int[] cost) {
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