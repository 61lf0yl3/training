import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BuildingsWithanOceanView {
    // Approach 1: Monotonic Stack Space Optimization
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> tempRes = new ArrayList<>();
        int n = heights.length;
        int highestSoFar = heights[n - 1];
        tempRes.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > highestSoFar) {
                tempRes.add(i);
                highestSoFar = heights[i];
            }
        }
        int m = tempRes.size();
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = tempRes.get(m - 1 - i);
        }
        return res;
    }

    // Approach 2: Linear Iteration
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] findBuildings2(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        for (int current = 0; current < n; ++current) {
            // If the current building is taller,
            // it will block the shorter building's ocean view to its left.
            // So we pop all the shorter buildings that have been added before.
            while (!list.isEmpty() && heights[list.get(list.size() - 1)] <= heights[current]) {
                list.remove(list.size() - 1);
            }
            list.add(current);
        }

        // Push elements from list to answer array.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // Approach 3: Monotonic Stack
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] findBuildings3(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        // Monotonically decreasing stack.
        Stack<Integer> stack = new Stack<>();
        for (int current = n - 1; current >= 0; --current) {
            // If the building to the right is smaller, we can pop it.
            while (!stack.isEmpty() && heights[stack.peek()] < heights[current]) {
                stack.pop();
            }

            // If the stack is empty, it means there is no building to the right
            // that can block the view of the current building.
            if (stack.isEmpty()) {
                list.add(current);
            }

            // Push the current building in the stack.
            stack.push(current);
        }

        // Push elements from list to answer array in reverse order.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(list.size() - 1 - i);
        }

        return answer;
    }
}